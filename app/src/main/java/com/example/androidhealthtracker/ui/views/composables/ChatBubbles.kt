package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IncomingMessageBubble(
    message: String,/*TODO: Message is of type message*/
    timestamp: String,/* message.timestamp*/
    color: Color
) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(12.dp)
        ) {
            Text(
                text = message,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
        Text(
            text = timestamp,
            color = color,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun OutgoingMessageBubble(
    message: String,
    timestamp: String,
    color: Color
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = timestamp,
            color = color,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Blue)
                .padding(12.dp)
        ) {
            Text(
                text = message,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

//
//TODO: Setup Previews for the two message bubbles
@Preview(showBackground = true)
@Composable
fun MessageBubblesPreview(){
    Column{
        IncomingMessageBubble(
            message = "Hey, how's it going?",
            timestamp = "3:45 PM",
            color = Color.Gray
        )

    OutgoingMessageBubble(
        message = "I'm doing well, thanks for asking!",
        timestamp = "3:47 PM",
        color = Color.Gray/*Color of timestamp*/
    )
    }

}

