package com.example.androidhealthtracker.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidhealthtracker.R
import com.example.androidhealthtracker.navigation.Components
import com.example.androidhealthtracker.views.actions.MainScreenAction
import com.example.androidhealthtracker.views.composables.BottomNavBar
import com.example.androidhealthtracker.views.composables.ChatList
import com.example.androidhealthtracker.views.state.BottomNavItem

//
//TODO: Show the number of conversations a person has
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen (
    modifier: Modifier = Modifier,
    navController: NavController,
    onAction: (action:MainScreenAction) -> Unit
){
    Scaffold (
        modifier = modifier,
        topBar = { Text(text = "Doctors plaza")},
        bottomBar ={
            BottomNavBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home" ,
                        route = Components.ChatList.route,
                        icon = ImageVector.vectorResource(id = R.drawable.home)
                    ),
                    BottomNavItem(
                        name = "Call History" ,
                        route = Components.callList.route,
                        icon = ImageVector.vectorResource(id = R.drawable.call)
                    ),
                    BottomNavItem(
                        name = "Groups" ,
                        route = Components.GroupChatList.route,
                        icon = ImageVector.vectorResource(id = R.drawable.groups)
                    ),
                    BottomNavItem(
                        name = "Explore" ,
                        route = Components.ExploreComponent.route,
                        icon = ImageVector.vectorResource(id = R.drawable.explore)
                    ),
                ),
                navController = navController,
                onItemClick = {
                    //
                    //Navigate on item clicked
                    navController.navigate(it.route)
                }
        )}
    ){
        //
        //Body content a navigation composable
        NavHost(
            navController = navController as NavHostController,
            startDestination = Components.ChatList.route
        ){
            //
            //Chat list ui
            composable(route = Components.ChatList.route){
                //
                // Chat list composable that shows the list of per to per chats
//                ChatList(
////                    conversations = ,
//                    onAction = {}
//                )
            }
            //
            //Call history list ui
            composable(route = Components.callList.route){
                //
                //TODO: Create a list of all past call to show call history
            }
            //
            //Group chats list ui
            composable(route = Components.GroupChatList.route){
                //
                //TODO: create a composable to list all Group chat rooms
            }
            //
            //Explore - returns a list of doctors
            composable(route =Components.ExploreComponent.route){
                //
                //TODO: Implement the explore component to show list of doctors
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen(
        navController = rememberNavController(),
        onAction = {}
    )
}
