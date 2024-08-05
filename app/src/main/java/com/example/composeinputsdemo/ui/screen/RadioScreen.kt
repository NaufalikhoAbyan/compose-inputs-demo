package com.example.composeinputsdemo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.ui.components.DemoTopAppBar
import com.example.composeinputsdemo.ui.theme.ComposeInputsDemoTheme

@Composable
fun RadioScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            DemoTopAppBar(title = "Radio Demo", navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(24.dp)
                .padding(innerPadding)
        ) {
            val (radioValue, changeRadioValue) = remember {
                mutableStateOf("")
            }
            Text(text = "Value: $radioValue")
            val radioOptions = listOf("Radio 1", "Radio 2", "Radio 3")
            radioOptions.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = radioValue == item,
                            onClick = {
                                changeRadioValue(item)
                            }
                        )
                ) {
                    RadioButton(
                        selected = radioValue == item,
                        onClick = {
                            changeRadioValue(item)
                        }
                    )
                    Text(text = item)
                }
            }
        }
    }
}

@Preview
@Composable
private fun RadioScreenPreview() {
    ComposeInputsDemoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            RadioScreen()
        }
    }
}