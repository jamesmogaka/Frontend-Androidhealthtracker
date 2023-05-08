package com.example.androidhealthtracker.viewmodel

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.androidhealthtracker.navigation.Components
import com.example.androidhealthtracker.views.actions.PhoneNumberVerificationAction
import com.example.androidhealthtracker.views.state.PhoneNumberVerificationEntryState
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit


class PhoneNumberFormViewModel: ViewModel() {
//    var uiState by mutableStateOf(PhoneNumberFormUiState())
//        private set
    var entryState by mutableStateOf(PhoneNumberVerificationEntryState())
        private set


    private fun phoneNumberEntered(phoneNumber: String) {
        //Update the phone Number state
        entryState = entryState.copy(phoneNumber =phoneNumber)
    }

    private fun otpEntry(otpNUmber: String) {
        //update the otp
        entryState  = entryState.copy(OtpValue =otpNUmber)
    }

    private fun sendOtpFromFirebase(
        auth: FirebaseAuth,
        context:Context,
        navController: NavController
    ) {
        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                signInWithPhoneAuthCredential(credential = credential, auth = auth, navController =navController )
            }

            // TODO : Call error display dialog with error message for the user
            override fun onVerificationFailed(e: FirebaseException) {
                if (e is FirebaseAuthInvalidCredentialsException) {
                    println("Check credentials and try log in again")
                } else if (e is FirebaseTooManyRequestsException) {
                    println("We are currently down at the moment")
                }

            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.


                // Save verification ID and resending token so we can use them later
                 entryState = entryState.copy(storedVerificationId = verificationId)
                 var resendToken = token
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("${entryState.countryCode}${entryState.phoneNumber}")
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(context as Activity)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun submitOtp(
        auth: FirebaseAuth,
        navController: NavController
    ) {
        val credential = PhoneAuthProvider.getCredential(entryState.storedVerificationId, entryState.OtpValue)
        signInWithPhoneAuthCredential(credential = credential, auth = auth, navController =navController)
    }
    //
    //Return a user
    private fun signInWithPhoneAuthCredential(
        credential: PhoneAuthCredential,
        auth: FirebaseAuth,
        navController:NavController
    ) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    //
                    // Sign in success, update UI with the signed-in user's information
                    val user = task.result?.user
                    //
                    //Navigate to the user registration screen
                    navController.navigate(Components.UserRegistrationComponents.route){
                        popUpTo(Components.PhoneNumberVerificationComponents.route) {
                            inclusive = true
                        }
                    }
                } else {
                    //
                    // Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        //Show error dialog with error message of invalid otp
                    }
                    // Update UI
                }
            }
    }

    private fun countryCodeEntered(countryCode: String) {
        //
        //Update the country code state
        entryState = entryState.copy(countryCode = countryCode)
    }

    fun onAction (action: PhoneNumberVerificationAction) {
        when (action) {
            //
            //Enables send otp button
            is PhoneNumberVerificationAction.PhoneNumber -> phoneNumberEntered(action.phoneNumber)

            //
            //
            is PhoneNumberVerificationAction.CountryCode -> countryCodeEntered(action.countryCode)
            //
            //sends phone number to the server for sending of otp from server
            //Also show the otp verification screen
            is PhoneNumberVerificationAction.Ok -> sendOtpFromFirebase(auth = action.auth, context = action.context, navController = action.navController)

            //
            //Enable the submit otp button
            is PhoneNumberVerificationAction.OtpEntry -> otpEntry(action.otpNUmber)
            //
            //Sends the otp to the server for verification and signup
            is PhoneNumberVerificationAction.Submit -> submitOtp(auth =action.auth, navController = action.navController)
        }
    }
}
