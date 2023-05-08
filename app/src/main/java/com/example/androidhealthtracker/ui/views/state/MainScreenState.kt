package com.example.androidhealthtracker.views.state

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androidhealthtracker.model.Message

//
//Bottom Navigation State
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgecount: Int = 0,
)
//
//Conversations card state
data class ConversationCardItem(
    val user: String,/*TODO: User & message models*/
    val Message: String
)

//
//Chat room
data class ChatRoom(
    val id: Int,
    val name: String,
    val lastMessage: Message,
    val messages: List<Message>
)