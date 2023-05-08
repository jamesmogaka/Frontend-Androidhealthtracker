package com.example.androidhealthtracker.views.state

import java.time.LocalDate

data class PatientRegistrationState(
    var firstName: String = "",
    var lastName: String = "",
    var dateOfBirth: String = "",
    var physicalAddress: String = ""
)

data class DoctorRegistrationState(
    var firstName : String = "",
    var lastName : String = "",
    var specification: String = ""
)