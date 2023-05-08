package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidhealthtracker.model.Message
import com.example.androidhealthtracker.views.state.ChatRoom


@Composable
fun ChatCard(
    chatRoom: ChatRoom,
    message: Message,
    color: Color = Color.Black,
    onClickAcrion: ()->Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(color)
        ) {
            Text(
                text = "",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = chatRoom.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Text(
                text = message.messageContent,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Text(
            text = "3:45 PM",/*TODO: Message timestamp message.timestamp */
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

//
//TODO: Setup a preview
//@Preview(showBackground = true)
//@Composable
//fun ChatCardPreview(){
//    ChatCard(firstName = "James", lastName = "Mogaka", message = "I am the best of the best" )
//}