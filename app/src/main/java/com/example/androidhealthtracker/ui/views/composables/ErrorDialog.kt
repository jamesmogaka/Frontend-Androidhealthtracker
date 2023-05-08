package com.example.androidhealthtracker.views.composables


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidhealthtracker.R

@Composable
fun ErrorDialog(
    errorMessage: String,
    recommendationMessage: String = "",
    dismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = dismiss,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.error),
                    contentDescription = "Error icon",
                    tint = MaterialTheme.colors.error,
                    modifier = Modifier.size(48.dp)
                )
                Text(
                    text = "Error",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        },
        text =  {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                if (recommendationMessage.isNotEmpty()) {
                    Text(
                        text = recommendationMessage,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = dismiss,
//                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "OK")
            }
        }
    )
}


@Preview
@Composable
fun defaultError(){
    ErrorDialog(errorMessage ="Invalid user") {
        //TODO:
    }
}