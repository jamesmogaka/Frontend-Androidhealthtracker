package com.example.androidhealthtracker.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen(
    messages: /*List<Message>*/List<String>,
    currentUser: /*User*/ String,
    onSendMessage: (String) -> Unit,
    onNavigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        /*
                        TODO: use contact card here
                        CircleAvatar(
                            text = currentUser.name.substring(0, 1),
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = currentUser.name)
                    */
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Navigate up")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                backgroundColor = Color.White,
                elevation = 4.dp,
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp),
                            shape = RoundedCornerShape(24.dp),
                            placeholder = { Text(text = "Type a message...") }
                        )
                        IconButton(
                            onClick = { onSendMessage("") },
                            modifier = Modifier.size(48.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Send,
                                contentDescription = "Send"
                            )
                        }
                    }
                }
            )
        },
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(messages) { message ->
                        /*TODO: implement chat buble logic
                        MessageBubble(
                            message = message,
                            isCurrentUser = message.senderId == currentUser.userId
                        )*/
                    }
                }
            }
        }
    )
}
