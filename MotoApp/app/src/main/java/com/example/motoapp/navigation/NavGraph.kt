package com.example.motoapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.motoapp.ui.screens.MotoScreen
import com.example.motoapp.ui.screens.HomeScreen
import com.example.motoapp.models.motoList

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen { onMotoSelected ->
                navController.navigate("moto/${onMotoSelected.name}")
            }
        }
        composable("moto/{moto}"){ backStackEntry ->
            val motoName = backStackEntry.arguments?.getString("moto")
            val selectedMoto = motoList.first { it.name == motoName }
            MotoScreen(selectedMoto)
        }
    }
}