package com.example.composeinputsdemo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.ui.components.DemoTopAppBar
import com.example.composeinputsdemo.ui.theme.ComposeInputsDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            DemoTopAppBar(title = "Dropdown demo", navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(24.dp)
        ) {
            val dropdownOptions = listOf(
                "Option 1",
                "Option 2",
                "Option 3",
                "Option 4",
            )
            val (selectedValue, onSelectedValueChange) = remember {
                mutableStateOf(dropdownOptions[0])
            }
            val (dropdownExpanded, onDropdownExpandedChange) = remember {
                mutableStateOf(false)
            }
            Column(
                modifier = modifier
            ) {
                ExposedDropdownMenuBox(
                    expanded = dropdownExpanded,
                    onExpandedChange = {
                        onDropdownExpandedChange(it)
                    }
                ) {
                    TextField(
                        value = selectedValue,
                        onValueChange = { },
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownExpanded)
                        },
                        modifier = Modifier.fillMaxWidth().menuAnchor()
                    )
                    ExposedDropdownMenu(expanded = dropdownExpanded, onDismissRequest = { onDropdownExpandedChange(false) }) {
                        dropdownOptions.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(text = item)
                                },
                                onClick = {
                                    onSelectedValueChange(item)
                                    onDropdownExpandedChange(false)
                                },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DropdownScreenPreview() {
    ComposeInputsDemoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            DropdownScreen()
        }
    }
}