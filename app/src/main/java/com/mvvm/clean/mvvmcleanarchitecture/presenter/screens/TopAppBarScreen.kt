package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import android.graphics.pdf.models.ListItem
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarScreen(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("Top App Bar Screen")
                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Localized description"
                        )
                    }

                },
                scrollBehavior = scrollBehavior
            )
        },

    ) { innerPadding ->
      Box(modifier = Modifier.padding(innerPadding)){
          LazyColumn {
              items(getTopAppBarListData().count()) { item ->
                  TopAppBarListItem(getTopAppBarListData()[item])
              }
          }
      }
        // Content of the screen goes here


    }


}
@Composable
fun TopAppBarListItem(appBarName : String){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight()
            .clickable {
                if(appBarName == "Top App Bar with Title") {
                    // Navigate to Top App Bar with Title screen
                } else if(appBarName == "Top App Bar with Navigation Icon") {
                    // Navigate to Top App Bar with Navigation Icon screen
                } else if(appBarName == "Top App Bar with Actions") {
                    // Navigate to Top App Bar with Actions screen
                } else if(appBarName == "Top App Bar with Search") {
                    // Navigate to Top App Bar with Search screen
                } else if(appBarName == "Top App Bar with Dropdown Menu") {
                    // Navigate to Top App Bar with Dropdown Menu screen
                } else if(appBarName == "Top App Bar with Custom Layout") {
                    // Navigate to Top App Bar with Custom Layout screen
                }
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

    ) {
        Text(
            text = appBarName,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
fun getTopAppBarListData(): List<String> {
    return listOf(
        "Top App Bar with Title",
        "Top App Bar with Navigation Icon",
        "Top App Bar with Actions",
        "Top App Bar with Search",
        "Top App Bar with Dropdown Menu",
        "Top App Bar with Custom Layout",
        "Top App Bar with Title",
        "Top App Bar with Navigation Icon",
        "Top App Bar with Actions",
        "Top App Bar with Search",
        "Top App Bar with Dropdown Menu",
        "Top App Bar with Custom Layout",
        "Top App Bar with Title",
        "Top App Bar with Navigation Icon",
        "Top App Bar with Actions",
        "Top App Bar with Search",
        "Top App Bar with Dropdown Menu",
        "Top App Bar with Custom Layout"
    )
}