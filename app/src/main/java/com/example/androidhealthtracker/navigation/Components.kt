package com.example.androidhealthtracker.navigation

sealed class Components(val route: String){
    //
    //Screens
    object SplashComponents: Components("splash_screen")
    object PhoneNumberVerificationComponents: Components("phone_number_Verification_screen")
    object UserRegistrationComponents: Components("user_registration_screen")
    object MainScreen: Components("main_screen")
    object ExploreComponent: Components("explore_screen")
    object ChatRoomScreen: Components("chat_screen")
    object SettingScreen: Components("Setting_screen")
    object ProfileScreen: Components("profie_screen")

    //
    //Composable
    object ChatList: Components("chat_list")
    object GroupChatList:Components("group_chat_list")
    object callList: Components("call_list")

}
