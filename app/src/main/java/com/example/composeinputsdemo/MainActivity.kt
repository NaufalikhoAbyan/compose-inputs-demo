package com.example.composeinputsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.navigation.GlobalNavigation
import com.example.composeinputsdemo.navigation.Routes
import com.example.composeinputsdemo.ui.theme.ComposeInputsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeInputsDemoTheme {
                GlobalNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Inputs Demo")
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate(Routes.TextField.name)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
               
                Text(text = "Text Fields")
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    ComposeInputsDemoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MainScreen()
        }
    }
}