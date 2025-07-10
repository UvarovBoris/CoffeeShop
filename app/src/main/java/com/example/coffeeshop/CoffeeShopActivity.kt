package com.example.coffeeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeeshop.navigation.AppNavHost
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoffeeShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        var keepSplash = true
        splashScreen.setKeepOnScreenCondition {
            keepSplash
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<CoffeeShopViewModel>()
            CoffeeShopTheme {
                val startDestination by viewModel.startDestinationState.collectAsStateWithLifecycle()
                startDestination?.let {
                    keepSplash = false
                    AppNavHost(startDestination = it)
                }
            }
        }
    }
}