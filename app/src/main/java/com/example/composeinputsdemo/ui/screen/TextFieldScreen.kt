package com.example.composeinputsdemo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.ui.theme.ComposeInputsDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(text = "Text Fields Demo", style = MaterialTheme.typography.headlineLarge)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = modifier.padding(24.dp).padding(innerPadding)
        ) {
            TextFieldDemo()
            OutlinedTextFieldDemo()
            BasicTextFieldDemo()
        }
    }
}

@Composable
private fun BasicTextFieldDemo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val basicTextFieldValue = remember {
            mutableStateOf("")
        }
        Text(text = "Basic Text Field", style = MaterialTheme.typography.headlineMedium)
        BasicTextField(
            value = basicTextFieldValue.value,
            onValueChange = {
                basicTextFieldValue.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "*Basic text field doesn't have any styling",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.alpha(0.75f)
        )
        Text(
            text = "Value: ${basicTextFieldValue.value}",
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
private fun OutlinedTextFieldDemo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val outlineTextFieldValue = remember {
            mutableStateOf("")
        }
        Text(text = "Outlined Text Field", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = outlineTextFieldValue.value,
            onValueChange = {
                outlineTextFieldValue.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Value: ${outlineTextFieldValue.value}",
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
private fun TextFieldDemo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val textFieldValue = remember {
            mutableStateOf("")
        }
        Text(text = "Text Field", style = MaterialTheme.typography.headlineMedium)
        TextField(
            value = textFieldValue.value,
            onValueChange = {
                textFieldValue.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Value: ${textFieldValue.value}", style = MaterialTheme.typography.labelLarge)
    }
}

@Preview
@Composable
private fun TextFieldScreenPreview() {
    ComposeInputsDemoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            TextFieldScreen()
        }
    }
}