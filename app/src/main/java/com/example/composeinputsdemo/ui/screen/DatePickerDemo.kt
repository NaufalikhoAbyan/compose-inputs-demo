package com.example.composeinputsdemo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.ui.components.DemoTopAppBar
import com.example.composeinputsdemo.ui.theme.ComposeInputsDemoTheme
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDemoScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            DemoTopAppBar(title = "Date Picker Demo", navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(24.dp)
                .padding(innerPadding)
        ) {
            val datePickerState = rememberDatePickerState()
            val openDatePicker = remember {
                mutableStateOf(false)
            }
            val selectedDate = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = selectedDate.value,
                readOnly = true,
                onValueChange = { },
                label = { Text(text = "Date Picker with Text Field") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            openDatePicker.value = true
                        }
                    ) {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                    }
                }
            )
            if (openDatePicker.value) {
                Dialog(
                    onDismissRequest = { openDatePicker.value = false }
                ) {
                    Card {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            DatePicker(state = datePickerState, showModeToggle = false)
                            Row(
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(
                                    onClick = {
                                        openDatePicker.value = false
                                        datePickerState.selectedDateMillis = null
                                    }
                                ) {
                                    Text(text = "Cancel")
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Button(
                                    onClick = {
                                        selectedDate.value = convertToDate(datePickerState.selectedDateMillis)
                                        openDatePicker.value = false
                                    }
                                ) {
                                    Text(text = "Ok")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DatePickerDemoScreenPreview() {
    ComposeInputsDemoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            DatePickerDemoScreen()
        }
    }
}

fun convertToDate(millis: Long?): String {
    val formatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.forLanguageTag("ID"))
    return formatter.format(millis)
}