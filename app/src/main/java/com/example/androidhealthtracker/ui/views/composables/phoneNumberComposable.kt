package com.example.androidhealthtracker.views.composables


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PhoneNumberInput(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    countryCode: String,
    onCountryCodeChange: (String) -> Unit,
) {
    val countryCodes = listOf("+1", "+91", "+44", "+55","+254","+257")
    var expanded by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "$phoneNumber",
        onValueChange = { newValue ->
                onPhoneNumberChange(newValue)
        },
        label = { Text("Phone Number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        leadingIcon = {
            Box(
                modifier = Modifier.width(60.dp)
                    .clickable { expanded = true }
                    .padding(end = 8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(text = countryCode, style = MaterialTheme.typography.body1)
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth(0.3f)
                ) {
                    countryCodes.forEach { code ->
                        DropdownMenuItem(
                            onClick = {
                                onCountryCodeChange(code)
                                expanded = false
                            }
                        ) {
                            Text(text = code)
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PhoneNumberInputPreview(){
    var countryCode by remember {
        mutableStateOf("+1")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    PhoneNumberInput(
        phoneNumber= phoneNumber,
        onPhoneNumberChange = {
            //regex Check
            phoneNumber = it
    },
        countryCode = countryCode,
        onCountryCodeChange = {
            countryCode = it
        }
    )
}

