package com.example.androidhealthtracker.views.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun SpecificationDropdownTextField(
    items: List<String>,
    selectedValue: String?,
    onValueSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedIndex = items.indexOf(selectedValue)

    OutlinedTextField(
        value = selectedValue ?: "",
        onValueChange ={
                       //
                       // Event
        },
        readOnly = true,
        modifier = Modifier.clickable{ expanded = true }.fillMaxWidth(),
        label = { Text("Select Specification field ") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.clickable(onClick = { expanded = true })
            )
        }
    )
    //
    //
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        items.forEachIndexed { index, item ->
            DropdownMenuItem(
                onClick = {
                    onValueSelected(item)
                    expanded = false
                },
                enabled = selectedIndex != index
            ) {
                Text(item)
            }
        }
    }
}
