package com.example.composeinputsdemo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.ui.components.DemoTopAppBar
import com.example.composeinputsdemo.ui.theme.ComposeInputsDemoTheme

@Composable
fun CheckboxScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            DemoTopAppBar(title = "Checkbox Demo", navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            IndividualCheckbox()
        }
    }
}

@Composable
private fun IndividualCheckbox() {
    Column {
        Text(text = "Individual Checkboxes", style = MaterialTheme.typography.headlineMedium)
        LazyColumn {
            items(3) {
                IndividualCheckboxItem(number = it + 1)
            }
        }
    }
}

@Composable
private fun IndividualCheckboxItem(number: Int) {
    Column {
        val checkboxValue = remember {
            mutableStateOf(false)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Checkbox $number value: ${checkboxValue.value}")
            Checkbox(
                checked = checkboxValue.value,
                onCheckedChange = {
                    checkboxValue.value = it
                }
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black)
        )
    }
}

@Preview
@Composable
private fun CheckboxScreenPreview() {
    ComposeInputsDemoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CheckboxScreen()
        }
    }
}