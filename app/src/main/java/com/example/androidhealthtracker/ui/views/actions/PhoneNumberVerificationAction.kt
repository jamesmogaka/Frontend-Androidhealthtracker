package com.example.androidhealthtracker.views.actions

import android.content.Context
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

sealed class PhoneNumberVerificationAction{
    data class PhoneNumber(val phoneNumber: String): PhoneNumberVerificationAction()
    data class CountryCode(val countryCode: String): PhoneNumberVerificationAction()
    data class Ok(val auth:FirebaseAuth , val context: Context, val navController: NavController): PhoneNumberVerificationAction()
    data class OtpEntry(val otpNUmber: String): PhoneNumberVerificationAction()
    data class Submit(val auth: FirebaseAuth, val navController: NavController): PhoneNumberVerificationAction()
}
