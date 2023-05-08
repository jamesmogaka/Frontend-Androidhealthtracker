package com.example.androidhealthtracker.views.composables



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.androidhealthtracker.views.actions.PhoneNumberVerificationAction
import com.example.androidhealthtracker.views.composables.OTPInput
import com.google.firebase.auth.FirebaseAuth

@Composable
fun OtpVerification(
    modifier:Modifier = Modifier,
    otpValue: MutableState<String>,
    auth: FirebaseAuth,
    navController: NavController,
    onAction: (action:PhoneNumberVerificationAction) -> Unit
){
    /*TODO:
        1.display the custom otp input field
        2.Create a resend otp link that is activated after sometime
        3.Create a timer composable to show the countdown till one is able to resend otp code
        4.Create a submit button which would be used to verify the otp entered above
        5.Further editing for beatification purposes
    * */
    val context = LocalContext.current
    Column(
        modifier = modifier
    ){
        //
        //step 1
        OTPInput(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            otpValue = otpValue,
            onAction = onAction
        )
        //
        //Step 2
        //Todo: this text should be clickable and only enabled after a duration of time
        Text(
            text = "Resend otp sms.",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        //
        //Step 3
        //Todo:Create a timer composable to display a countdown till the resend link is activated
        //
        //Step 4
        Button(
            onClick = {onAction(PhoneNumberVerificationAction.Submit(auth = auth, navController = navController))},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit OTP")
        }
    }
}