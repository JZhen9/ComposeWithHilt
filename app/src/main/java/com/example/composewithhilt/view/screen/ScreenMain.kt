package com.example.composewithhilt.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composewithhilt.view.Routes
import com.example.composewithhilt.view.component.BottomMenu

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomMenu(navController) }
    ) {
        NavHost(navController = navController, startDestination = Routes.Home.route) {
            composable(route = Routes.Home.route) {
                HomePage(viewModel = hiltViewModel())
            }

            composable(route = Routes.Income.route) {
                IncomePage(viewModel = hiltViewModel())
            }

            composable(route = Routes.PayOut.route) {
                PayOutPage(viewModel = hiltViewModel())
            }

        }
    }
}