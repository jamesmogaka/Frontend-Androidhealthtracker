package com.example.androidhealthtracker.model

data class Message(
    val senderId: Int,
    val roomId: Int,
    val senderType: String,
    val messageContent: String,
    val timeStamp:Long = System.currentTimeMillis()
)


