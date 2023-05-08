package com.example.androidhealthtracker.views.actions

import java.time.LocalDate

sealed class UserRegistrationAction {

    data class FirstName(val firstName:String, val userType: String): UserRegistrationAction()
    data class LastName(val lastName:String, val userType: String): UserRegistrationAction()
    data class Specification(val specification:String): UserRegistrationAction()
    data class DateOfBirth(val dateOfBirth: String): UserRegistrationAction()
    data class PhysicalAddress(val physicalAddress:String): UserRegistrationAction()
    object SubmitPatient: UserRegistrationAction()
    object SubmitDoctor: UserRegistrationAction()
}