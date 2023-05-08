package com.example.androidhealthtracker.views.composables

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ConfirmationDialogue(
    onEditClick: () -> Unit,
    onOkClick: () -> Unit,
    phoneNumber: String,
    showDialog: MutableState<Boolean>
) {

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = {
                Text(text = "Confirmation of ${phoneNumber}")
            },
            text = {
                Text(text = "Is the number provided ok or would you like to edit?")
            },
            //TODO: customise dialog box buttons!!!!!!
            confirmButton = {
                Button(onClick = {
                    onOkClick()
                    showDialog.value = false
                }) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                Button(onClick = {
                    onEditClick()
                    showDialog.value= false
                }) {
                    Text(text = "EDIT")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmationComposablePreview(){
    ConfirmationDialogue(onEditClick = { /*TODO*/ }, onOkClick = { /*TODO*/ }, phoneNumber = "+254 742977779", remember {
        mutableStateOf(false)
    })
}