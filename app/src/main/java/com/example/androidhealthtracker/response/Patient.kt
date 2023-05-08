package com.example.androidhealthtracker.response

data class Patient(
    val contact: String,
    val current_prescription: Any,
    val date_of_birth: String,
    val f_name: String,
    val history: Any,
    val id: Int,
    val l_name: String,
    val patient_address: String
)