package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidhealthtracker.views.actions.MainScreenAction
import com.example.androidhealthtracker.views.state.ChatRoom

@Composable
fun ChatList(
    modifier: Modifier = Modifier,
    conversations: List<ChatRoom>,
    onAction: (action:MainScreenAction) -> Unit
){
//    val conversations = viewModel.chatRooms.observeAsState(emptyList())
    LazyColumn{
//        items(conversations.value) { message ->
            //
//            ChatCard(
//                firstName = ,
//                lastName = ,
//                message =
//            )
//        }
    }
}