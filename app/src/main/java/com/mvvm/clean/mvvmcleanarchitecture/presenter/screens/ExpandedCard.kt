package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ExpandedCard(navController: NavHostController) {
    var expaded by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expaded) 180f else 0f,
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),

        ) {
        Card(
            colors = cardColors(
                containerColor = Color(0xFFEEF1F3)
            ),
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .clickable {
                    expaded = !expaded
                },


            ) {

            Column {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Expanded Card",
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(6f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        modifier = Modifier
                            .alpha(0.5f)
                            .weight(1f)
                            .rotate(rotationState),
                        onClick = { expaded = !expaded },
                        enabled = true
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expand/Collapse",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                        )
                    }
                }
                if (expaded) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "This is an expanded card. You can add more content here.",
                            fontSize = 14.sp,
                            color = Color(0xFF333333)
                        )
                        Text(
                            text = "You can also add images, buttons, or any other composables.",
                            fontSize = 14.sp,
                            color = Color(0xFF333333)
                        )
                    }
                }
            }
        }

    }
}


@Preview(name = "ExpandedCardPreview")
@Composable
fun ExpandedCardPreview() {
    // ExpandedCard(navController = NavHostController(ApplicatonProvider.getApplicationContext()))
}