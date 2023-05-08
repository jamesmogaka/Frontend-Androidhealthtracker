package com.example.androidhealthtracker.views.state

//
//Try to implement ui state logic in the ui
//TODO: Investigate on liveData and flows in kotlin

data class PhoneNumberVerificationEntryState(
    var countryCode:String = "+1",
    var phoneNumber:String = "",
    var OtpValue: String = "",
    var storedVerificationId: String = ""
)