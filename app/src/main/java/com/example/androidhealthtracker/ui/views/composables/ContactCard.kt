package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactCard(
    firstName: String,
    lastName: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .background(color = backgroundColor, shape = CircleShape)
                    .padding(16.dp)
            ) {
                Text(
                    text = "${firstName[0]}${lastName[0]}".uppercase(),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text ="${lastName[0].uppercase()}${lastName.substring(1,lastName.length)}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//
//TODO: Setup a preview
@Preview(showBackground = true)
@Composable
fun ContactCardPreview(){
    ContactCard(
        firstName = "james",
        lastName = "mogaka"
    )
}
