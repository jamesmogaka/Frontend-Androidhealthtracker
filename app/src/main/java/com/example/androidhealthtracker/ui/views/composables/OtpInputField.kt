package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidhealthtracker.views.actions.PhoneNumberVerificationAction

@Composable
fun OTPInput(
    modifier: Modifier = Modifier,
    otpValue: MutableState<String>,
    onAction: (PhoneNumberVerificationAction) -> Unit
) {
    BasicTextField(
        value = otpValue.value,
        onValueChange = {
            if (it.length <= 6) {
                otpValue.value = it
                onAction(PhoneNumberVerificationAction.OtpEntry(it))
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(6) { index ->
                    val char = when {
                        index >= otpValue.value.length -> ""
                        else -> otpValue.value[index].toString()
                    }

                    val isFocused = otpValue.value.length == index
                    Text(
                        modifier = Modifier
                            .width(40.dp)
                            .border(
                                if (isFocused) 2.dp
                                else 1.dp,
                                Color.Gray,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp),
                        text = char,
                        style = MaterialTheme.typography.h4,

                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        },
        modifier = modifier
    )
}
