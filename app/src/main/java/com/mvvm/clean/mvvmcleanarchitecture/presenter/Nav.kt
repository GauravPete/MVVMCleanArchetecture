package com.mvvm.clean.mvvmcleanarchitecture.presenter

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.AppScreen
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.BackgroundIndicator
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.CoilImageLib
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.ExpandedCard
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.FilterListScreen
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.GradientButtons
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.MaxCharLimitTextField
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.PasswordTextField
import com.mvvm.clean.mvvmcleanarchitecture.presenter.screens.TextField_demo

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") { AppScreen(navController) }
        composable("TextField") { TextField_demo(navController) }
        composable("ExpandedCard") { ExpandedCard(navController) }
        composable("CoilImage") { CoilImageLib(navController) }
        composable("PasswordTextField") { PasswordTextField(navController) }
        composable("GradientButton") { GradientButtons() }
        composable("MaxCharTextField") { MaxCharLimitTextField() }
        composable("BackgroundIndicator") { BackgroundIndicator() }
        composable("FilterList") { FilterListScreen() }
    }

}