package com.example.androidhealthtracker.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidhealthtracker.views.actions.PhoneNumberVerificationAction
import com.example.androidhealthtracker.views.composables.ConfirmationDialogue
import com.example.androidhealthtracker.views.composables.OtpVerification
import com.example.androidhealthtracker.views.composables.PhoneNumberInput
import com.example.androidhealthtracker.views.state.PhoneNumberVerificationEntryState
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VerifyPhoneNumberScreen(
    entryState:PhoneNumberVerificationEntryState,
    navController: NavController,
    auth: FirebaseAuth,
    onAction: (PhoneNumberVerificationAction) -> Unit
) {
//
    //
    //context
    val context = LocalContext.current
    //
    //Ui states
    var isOtpButtonEnabled by remember {
        mutableStateOf(false)
    }
    var showPhoneNumberConfirmationDialog = remember {
        mutableStateOf(false)
    }
    var showOtpVerificationInterface by remember {
        mutableStateOf(false)
    }
    var isSubmitButtonEnabled by remember {
        mutableStateOf(false)
    }

    //
/* //TODO: Create a dialog for the user to confirm the entered number
       ==========================================================================================================================================
                   * 1. Dialog should have two buttons and additional info to keep the user on the loop
                   * 2. Edit the entered number
                   * 3. Ok to send otp code
                   * The ok button should also reveal a fragment to input and verify the sent otp within the same activity
                   * if operation is successful the application navigates to the main screen of the app which displays a list of conversations
                   * it also sync the contacts in the device with the users within the application and creates a profile for each user
       =========================================================================================================================================
      * */
    //
    //
    //
    //confirmation dialog
    ConfirmationDialogue(
        onEditClick = {
            /*TODO:
            *  Navigate back to the phoneNumberForm screen passing the entered number as an argument
            * */
            //Repetition
            showPhoneNumberConfirmationDialog.value = false
        },
        onOkClick = {
            /*TODO:
            *   Contact firebase for generation of user token
            *   Load the composable responsible for the verification of otp and appropriate button
            * */
            onAction(PhoneNumberVerificationAction.Ok(auth = auth, context =context, navController = navController))
            //
            //Show the otp confirmation interface below the phone number interface
            showOtpVerificationInterface = true
        },
        phoneNumber = "${entryState.countryCode} ${entryState.phoneNumber}",
        showDialog = showPhoneNumberConfirmationDialog
        ,
    )
    //
    //
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Verify phone number", style =MaterialTheme.typography.h4 ) }
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "We will send you an OTP to verify your phone number, standard rates apply. Please enter your phone number below:",
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(16.dp))
                //
                //Custom phone number input field
                PhoneNumberInput(
                    phoneNumber=entryState.phoneNumber,
                    onPhoneNumberChange = {
                        //call the nessesary event to update the state
                        onAction(PhoneNumberVerificationAction.PhoneNumber(it))
                        //enable the send otp button as long as the text view is not empty
                        if(entryState.phoneNumber.isNotEmpty()) {
                            isOtpButtonEnabled = true
                        }
                    },
                    countryCode = entryState.countryCode,
                    onCountryCodeChange = {
                        onAction(PhoneNumberVerificationAction.CountryCode(it))
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        showPhoneNumberConfirmationDialog.value = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isOtpButtonEnabled
                ) {
                    Text("Send OTP")
                }
                //disable editing in the phone number input field
                //
                if (showOtpVerificationInterface){
                    OtpVerification(
                        otpValue = remember {
                        mutableStateOf(entryState.OtpValue)
                        },
                        auth = auth,
                        navController = navController,
                        onAction ={ action ->
                            onAction(action)
                        }
                    )
                }
            }
        }

    )
}
