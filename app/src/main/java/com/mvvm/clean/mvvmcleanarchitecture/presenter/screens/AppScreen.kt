package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Jetpack UI Component", fontWeight = FontWeight.W500) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            )
        )
    }, content = { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            LazyColumn {
                items(getListData().count()) { item ->
                    ListItem(getListData()[item], navController)

                }

            }
        }
    })

}

@Composable
fun ListItem(item: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(8.dp)
            .clickable {
                if (item == "Text Field") navController.navigate("TextField")
                else if (item == "Expanded Card") navController.navigate("ExpandedCard")
                else if (item == "Coil Image lib") {
                    navController.navigate("CoilImage")
                } else if (item == "Password Text Field") {
                    navController.navigate("PasswordTextField")
                } else if (item == "Gradient Button") {
                    navController.navigate("GradientButton")
                } else if (item == "Max Char Text Field") {
                    navController.navigate("MaxCharTextField")
                } else if (item == "Background Indicator") {
                    navController.navigate("BackgroundIndicator")
                } else if (item == "Filter list Screen") {
                    navController.navigate("FilterList")
                }
            },
    )
    {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item,
                modifier = Modifier.padding(16.dp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

    }
}

fun getListData(): List<String> {
    return listOf(
        "Text Field",
        "Expanded Card",
        "Coil Image lib",
        "Password Text Field",
        "Gradient Button",
        "Max Char Text Field",
        "Background Indicator",
        "Filter list Screen",
        "Item 9",
        "Item 10"
    )
}