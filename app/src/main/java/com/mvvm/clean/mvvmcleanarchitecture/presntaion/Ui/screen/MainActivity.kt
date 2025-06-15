package com.mvvm.clean.mvvmcleanarchitecture.presntaion.Ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mvvm.clean.mvvmcleanarchitecture.presntaion.Ui.compose.LazyListCompose
import com.mvvm.clean.mvvmcleanarchitecture.presntaion.viewmodel.PhotoListViewModel
import com.mvvm.clean.mvvmcleanarchitecture.ui.theme.MVVMCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCleanArchitectureTheme {
                LazyListCompose()
                //App()

            }
        }
    }
}

//https://picsum.photos/v2/list
@Composable
fun App(viewModel: PhotoListViewModel = viewModel<PhotoListViewModel>()) {

    val list = viewModel.photoList.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF6B459B),
                        Color(0xFF330B96)
                    )
                )
            )
            .height(400.dp),
    ) {
        if (list.value.isLoading) {
            Box(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center),
                    color = Color.White,
                    strokeWidth = 4.dp,

                    )
            }
        } else if (list.value.errorMessage != null) {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = list.value.errorMessage!!
            )
        } else {

            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            )
            {
                items(list.value.photoSizeList.size) {
                    Text(
                        text = list.value.photoSizeList[it].author,
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF6B459B),
                                        Color(0xFF330B96)
                                    )
                                )
                            ),

                        color = Color.White
                    )
                }
            }


        }

    }
}

