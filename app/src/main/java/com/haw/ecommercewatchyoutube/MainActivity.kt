package com.haw.ecommercewatchyoutube

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haw.ecommercewatchyoutube.ui.screens.DetailScreen
import com.haw.ecommercewatchyoutube.ui.screens.HomeScreen
import com.haw.ecommercewatchyoutube.ui.theme.EcommerceWatchYoutubeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()

            EcommerceWatchYoutubeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetupNavigation(navHostController = navHostController)
                }
            }
        }
    }
}

@Composable
fun SetupNavigation(navHostController: NavHostController) {
    NavHost(startDestination = "home", navController = navHostController) {
        composable(route = "home") {
            HomeScreen(navHostController = navHostController)
        }

        composable(route = "detail") {
            DetailScreen(onClickBack = { navHostController.popBackStack() })
        }
    }
}