package com.example.androidhealthtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.androidhealthtracker.navigation.Navigation
import com.example.androidhealthtracker.networking.RegistrationApi
import com.example.androidhealthtracker.networking.RemoteApi
import com.example.androidhealthtracker.ui.theme.AndroidhealthtrackerTheme
import com.example.androidhealthtracker.viewmodel.MainScreenViewModel
import com.example.androidhealthtracker.viewmodel.PhoneNumberFormViewModel
import com.example.androidhealthtracker.viewmodel.UserRegistrationViewModel
import com.google.firebase.auth.FirebaseAuth


class MainActivity : ComponentActivity() {
    //
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        //
        //firebase
        val auth = FirebaseAuth.getInstance()
        //
        //TODO: investigate on sign in persistence
        super.onCreate(savedInstanceState)
        setContent {
            AndroidhealthtrackerTheme {
                val phoneNumberFormViewModel = viewModel<PhoneNumberFormViewModel>()
                val userRegistrationViewModel = viewModel<UserRegistrationViewModel>()
                val mainScreenViewModel = viewModel<MainScreenViewModel>()
                val defaultNavController = rememberNavController()

                Navigation(
                    phoneNumberFormViewModel = phoneNumberFormViewModel,
                    auth = auth,
                    userRegistrationViewModel = userRegistrationViewModel,
                    defaultNavController = defaultNavController,
                    mainScreenViewModel = mainScreenViewModel
                )
            }
        }

    }
}