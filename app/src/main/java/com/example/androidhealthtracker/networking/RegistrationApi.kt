package com.example.androidhealthtracker.networking

import com.example.androidhealthtracker.response.Doctor
import com.example.androidhealthtracker.response.Patient
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegistrationApi {
    //
    //
    @FormUrlEncoded
    @POST("/user/doctor")
    suspend fun registerDoctor(
        @Field("firstName") firstName: String,
        @Field("lastName") lastName: String,
        @Field("specification") specification: String
    ): Response<Doctor>
    //
    //
    @FormUrlEncoded
    @POST("/user/patient")
    suspend fun registerPatient(
        @Field("firstName") firstName: String,
        @Field("lastName") lastName: String,
        @Field("dateOfBirth") dateOfBirth: String,
        @Field("physicalAddress") physicalAddress: String,

    ): Response<Patient>
}