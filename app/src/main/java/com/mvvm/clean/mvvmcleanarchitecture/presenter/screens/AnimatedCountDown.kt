package com.mvvm.clean.mvvmcleanarchitecture.presenter.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mvvm.clean.mvvmcleanarchitecture.presenter.viewmodels.AnimatedCountDownViewmodel

@Composable
fun AnimatedCountDown(viewmodel: AnimatedCountDownViewmodel = viewModel()) {
    val second = viewmodel.second.collectAsState(initial = "00")

    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Vertical Animation", fontSize = 20.sp)
        AnimatedContaint(second = second.value.toString(), isVertical = true)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Clip vertical Animation", fontSize = 20.sp)
        AnimatedContaint(second = second.value.toString(), clip = false, isVertical = true)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Horizontal Animation", fontSize = 20.sp)
        AnimatedContaint(second = second.value.toString(), isVertical = false)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Clip horizontal Animation", fontSize = 20.sp)
        AnimatedContaint(second = second.value.toString(), clip = false, isVertical = false)
        Spacer(modifier = Modifier.height(10.dp))
    }

}

@Composable
fun AnimatedContaint(second: String, clip: Boolean = true, isVertical: Boolean = true) {
    AnimatedContent(
        targetState = second,
        transitionSpec = {
            if (isVertical) {
                addVerticalAnimation().using(
                    SizeTransform(clip = clip)
                )
            } else {
                addHorizontalAnimation().using(
                    SizeTransform(clip = clip)
                )
            }

        }
    ) { targetCount ->
        Text(
            text = targetCount,
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp),
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            color = androidx.compose.ui.graphics.Color.Black
        )
    }
}

fun addHorizontalAnimation(duration: Int = 800): ContentTransform {
    return slideInHorizontally(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    ) togetherWith slideOutHorizontally(animationSpec = tween(durationMillis = duration)) { height -> -height } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    )
}

fun addVerticalAnimation(duration: Int = 800): ContentTransform {
    return slideInVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    ) togetherWith slideOutVertically(animationSpec = tween(durationMillis = duration)) { height -> -height } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    )
}