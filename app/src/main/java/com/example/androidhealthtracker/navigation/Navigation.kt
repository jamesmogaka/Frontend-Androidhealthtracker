package com.example.androidhealthtracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidhealthtracker.ui.views.SplashScreen
import com.example.androidhealthtracker.ui.views.VerifyPhoneNumberScreen
import com.example.androidhealthtracker.viewmodel.MainScreenViewModel
import com.example.androidhealthtracker.viewmodel.PhoneNumberFormViewModel
import com.example.androidhealthtracker.viewmodel.UserRegistrationViewModel
import com.example.androidhealthtracker.views.MainScreen
import com.example.androidhealthtracker.views.RegistrationScreen
import com.google.firebase.auth.FirebaseAuth


@Composable
fun Navigation(
    auth: FirebaseAuth,
    defaultNavController: NavController,
    phoneNumberFormViewModel:PhoneNumberFormViewModel,
    userRegistrationViewModel: UserRegistrationViewModel,
    mainScreenViewModel: MainScreenViewModel
){
    //
    //
    NavHost(
        navController = defaultNavController as NavHostController,
        startDestination = Components.SplashComponents.route,
    ){
        //
        //A navigation graph of composables
        composable(route = Components.SplashComponents.route ){
            SplashScreen(
                navController = defaultNavController
            )
        }
        //
        //
        composable(route = Components.PhoneNumberVerificationComponents.route){
            VerifyPhoneNumberScreen(
                entryState = phoneNumberFormViewModel.entryState,
                navController = defaultNavController,
                auth = auth,
                onAction = phoneNumberFormViewModel::onAction
            )
        }
        //
        //
        composable(route = Components.UserRegistrationComponents.route){
            RegistrationScreen(
                doctorRegistrationState = userRegistrationViewModel.doctorsRegistrationState,
                patientRegistrationState = userRegistrationViewModel.patientRegistrationState,
                onAction = userRegistrationViewModel::onAction
            )
        }
        //
        //Main Screen
        composable( route = Components.MainScreen.route){
            //
            //
            MainScreen(
                navController = defaultNavController,
                onAction = mainScreenViewModel::onAction
            )
        }
    }
}