package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidhealthtracker.R
import com.example.androidhealthtracker.views.actions.UserRegistrationAction
import com.example.androidhealthtracker.views.state.PatientRegistrationState
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate


@Composable
fun PatientsForm(
    modifier: Modifier = Modifier,
    patientRegistrationState: PatientRegistrationState,
    onAction: (action: UserRegistrationAction) -> Unit
){
    //
    //Selected date state
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    //
    //Date dialog state
    val dateDialogState = rememberMaterialDialogState()
    //Date picker dialog
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok") {
                //Callback whenever ok is clicked
            }
            negativeButton(text = "Cancel"){
                //Callback whenever the cancel is clicked
            }
        }
    ) {
        datepicker(
            initialDate = selectedDate,
            title = "Pick your Date of Birth",
        ) {
            selectedDate = it
        }
    }
    //
    //
    Column(modifier = modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = patientRegistrationState.firstName,
                onValueChange = {
                                onAction(UserRegistrationAction.FirstName(userType = "Patient", firstName = it))
                },
                label = { Text("First Name") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = patientRegistrationState.lastName,
                onValueChange = {
                    onAction(UserRegistrationAction.LastName(userType = "Patient", lastName = it))
                },
                label = { Text("Last Name") },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        //
        OutlinedTextField(
            value = selectedDate.toString(),
            onValueChange = {
                //
                //TODO:Event whenever a new date is selected by the user
                //  verification and validation of user input
                onAction(UserRegistrationAction.DateOfBirth(it))},
            readOnly = true,
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.calendar), contentDescription ="Calender icon", modifier = Modifier.clickable (onClick = {dateDialogState.show()}))
            },
            label = { Text("DoB") }
            )

        //
        //
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = patientRegistrationState.physicalAddress,
            onValueChange = {
                            onAction(UserRegistrationAction.PhysicalAddress(it))
            },
            label = { Text("Physical Address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onAction(UserRegistrationAction.SubmitPatient)
            }
        ) {
            Text("Submit")
        }
    }
}