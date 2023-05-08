package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidhealthtracker.views.actions.UserRegistrationAction
import com.example.androidhealthtracker.views.state.DoctorRegistrationState

@Composable
fun DoctorsForm(
    modifier:Modifier = Modifier,
    doctorRegistrationState: DoctorRegistrationState,
    onAction: (action: UserRegistrationAction) -> Unit
){
    Column(modifier = modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = doctorRegistrationState.firstName,
                onValueChange = {
                                onAction(UserRegistrationAction.FirstName(userType = "Doctor", firstName = it))
                },
                label = { Text("First Name") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = doctorRegistrationState.lastName,
                onValueChange = {
                    onAction(UserRegistrationAction.LastName(userType = "Doctor", lastName = it))
                },
                label = { Text("Last Name") },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        //
        //TODO:Implement specification dropdown
        SpecificationDropdownTextField(
            items = listOf("Pediatrician", "Dermatologists","Cardiologists", "Urologists", "Neurologists","Oncologists","Radiologists"),
            selectedValue = doctorRegistrationState.specification,
            onValueSelected = {
                // event on selection of specification
                onAction(UserRegistrationAction.Specification(specification = it))
            }
        )

        //
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onAction(UserRegistrationAction.SubmitDoctor)
            }
        ) {
                Text("Submit")
        }
    }
}