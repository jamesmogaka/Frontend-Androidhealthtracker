package com.example.androidhealthtracker.repository

import com.example.androidhealthtracker.networking.RegistrationApi

class RegistrationRepository(
    private val api :RegistrationApi
):BaseRepository() {
    suspend fun registerPatient(
        firstName: String,
        lastName: String,
        dateOfBirth: String,
        patientAddress: String
    )= safeApiCall {
        api.registerPatient(firstName,lastName,dateOfBirth,patientAddress)
    }
    suspend fun registerDoctor(
        firstName: String,
        lastName: String,
        specification: String
    )= safeApiCall {
        api.registerDoctor(firstName,lastName,specification)
    }

}