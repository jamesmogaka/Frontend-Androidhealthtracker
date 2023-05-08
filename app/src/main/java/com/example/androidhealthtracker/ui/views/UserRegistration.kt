package com.example.androidhealthtracker.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidhealthtracker.views.actions.UserRegistrationAction
import com.example.androidhealthtracker.views.composables.DoctorsForm
import com.example.androidhealthtracker.views.composables.PatientsForm
import com.example.androidhealthtracker.views.state.DoctorRegistrationState
import com.example.androidhealthtracker.views.state.PatientRegistrationState

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    doctorRegistrationState: DoctorRegistrationState,
    patientRegistrationState: PatientRegistrationState,
    onAction: (action: UserRegistrationAction) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registration: ") }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        val tabTitles = listOf("Doctor", "Patient")
        val (selectedTab, setSelectedTab) = remember { mutableStateOf(0) }

        TabRow(
            selectedTabIndex = selectedTab,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(innerPadding)
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTab == index,
                    onClick = { setSelectedTab(index) },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }


        when (selectedTab) {
            0 -> Box(modifier = Modifier.padding(top = 70.dp)) {DoctorsForm(onAction = onAction, doctorRegistrationState = doctorRegistrationState)}
            1 -> Box(modifier = Modifier.padding(top = 70.dp)) {PatientsForm(onAction = onAction, patientRegistrationState = patientRegistrationState)}
        }
    }
}