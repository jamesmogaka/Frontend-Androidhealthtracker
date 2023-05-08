package com.example.androidhealthtracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhealthtracker.views.actions.MainScreenAction
import com.example.androidhealthtracker.views.state.ChatRoom

class MainScreenViewModel: ViewModel() {
    //
    //Selected chat room and chat room list
    private val _selectedChatRoomId = MutableLiveData<Int>()
    val selectedChatRoomId: LiveData<Int> = _selectedChatRoomId

    private val _chatRooms = MutableLiveData<List<ChatRoom>>()
    val chatRooms: LiveData<List<ChatRoom>> = _chatRooms

    fun selectChatRoom(chatRoomId: Int) {
        _selectedChatRoomId.value = chatRoomId
    }
    //
    //Initialise the states for the main screen

    //
    //switch case to handle different ui events
    fun onAction (action: MainScreenAction){
        when(action){

            else -> {}
        }
    }
}