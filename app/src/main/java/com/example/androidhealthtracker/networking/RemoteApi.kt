package com.example.androidhealthtracker.networking

import com.google.firebase.auth.FirebaseAuth
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.X509Certificate

class RemoteApi {
    companion object{
        //
        //BASE URL TO THE REMOTE SERVER
        private const val BASE_URL = "http://192.168.100.4:8080/"
        //
        //Firebase auth id
        private const val AUTH_HEADER_KEY: String = "Auth"
    }

    fun<Api> buildApi(
        api: Class<Api>
    ): Api{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                // Get Firebase Auth user ID from FirebaseAuth instance
                val userId = FirebaseAuth.getInstance().currentUser?.uid

                // Add user ID header to request if user ID is not null
                val request = if (userId != null) {
                    chain.request().newBuilder()
                        .addHeader(AUTH_HEADER_KEY, userId)
                        .build()
                } else {
                    chain.request()
                }

                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
}

//setting up the instance of the registration api by creating a retrofit instance
object Registration {
    val api: RegistrationApi by lazy {
        RemoteApi().buildApi(RegistrationApi::class.java)
    }
}