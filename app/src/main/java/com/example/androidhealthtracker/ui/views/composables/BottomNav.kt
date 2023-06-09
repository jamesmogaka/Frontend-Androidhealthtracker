package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidhealthtracker.views.state.BottomNavItem

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation (
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ){
      items.forEach { item ->
          val selected = item.route == backStackEntry.value?.destination?.route
          BottomNavigationItem(
              selected = selected,
              onClick = { onItemClick(item)},
              icon = {
                  Column( horizontalAlignment = CenterHorizontally) {
                      if (item.badgecount > 0 ){
                          BadgedBox(badge ={
                              Text(text = item.badgecount.toString())
                          } ) {
                              Icon(
                                  imageVector = item.icon,
                                  contentDescription =item.name
                              )
                          }
                      } else{
                          Icon(
                              imageVector = item.icon,
                              contentDescription =item.name
                          )
                      }
                      //
                      //
                      if (selected){
                          Text(
                              text = item.name,
                              textAlign = TextAlign.Center,
                              fontSize = 10.sp
                          )
                      }
                  }
              }
          )
      }
    }
}