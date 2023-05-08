package com.example.androidhealthtracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhealthtracker.networking.Registration
import com.example.androidhealthtracker.repository.RegistrationRepository
import com.example.androidhealthtracker.views.actions.UserRegistrationAction
import com.example.androidhealthtracker.views.state.DoctorRegistrationState
import com.example.androidhealthtracker.views.state.PatientRegistrationState
import kotlinx.coroutines.launch

class UserRegistrationViewModel(): ViewModel(){
    //
    //Repository
    private val repository: RegistrationRepository = RegistrationRepository(Registration.api)
    //
    //States
    var patientRegistrationState : PatientRegistrationState by mutableStateOf(PatientRegistrationState())
        private set

    var doctorsRegistrationState: DoctorRegistrationState by mutableStateOf(DoctorRegistrationState())
        private set

    fun onAction (action:UserRegistrationAction){
        when(action){
            is UserRegistrationAction.DateOfBirth -> patientRegistrationState = patientRegistrationState.copy(dateOfBirth = action.dateOfBirth)
            is UserRegistrationAction.FirstName -> updateFirstName(userType = action.userType, firstName = action.firstName)
            is UserRegistrationAction.LastName -> updateLastName(userType = action.userType, lastName = action.lastName)
            is UserRegistrationAction.PhysicalAddress -> patientRegistrationState = patientRegistrationState.copy(physicalAddress = action.physicalAddress)
            is UserRegistrationAction.Specification -> doctorsRegistrationState = doctorsRegistrationState.copy(specification = action.specification)
            UserRegistrationAction.SubmitDoctor -> registerDoctor()
            UserRegistrationAction.SubmitPatient -> registerPatient()
        }
    }

    private fun registerPatient() = viewModelScope.launch {
            //
            //
            val response = repository.registerPatient(
                firstName = patientRegistrationState.firstName,
                lastName = patientRegistrationState.lastName,
                dateOfBirth = /*patientRegistrationState.dateOfBirth*/"2023-09-04",
                patientAddress = patientRegistrationState.physicalAddress
            )
        }


    private fun registerDoctor() =viewModelScope.launch {
        //
        //Submit doctor for registration in the server
        var response = repository.registerDoctor(
            firstName = doctorsRegistrationState.firstName,
            lastName = doctorsRegistrationState.lastName,
            specification = doctorsRegistrationState.specification
        )
    }

    private fun updateLastName(userType: String, lastName: String) {
        when(userType){
            "Doctor" -> {
                doctorsRegistrationState = doctorsRegistrationState.copy(lastName = lastName)
            }
            "Patient" -> {
                patientRegistrationState = patientRegistrationState.copy(lastName = lastName)
            }
        }
    }

    private fun updateFirstName(userType: String, firstName: String) {
        when(userType){
            "Doctor" -> {
                doctorsRegistrationState = doctorsRegistrationState.copy(firstName = firstName)
            }
            "Patient" -> {
                patientRegistrationState = patientRegistrationState.copy(firstName = firstName)
            }
        }
    }
}