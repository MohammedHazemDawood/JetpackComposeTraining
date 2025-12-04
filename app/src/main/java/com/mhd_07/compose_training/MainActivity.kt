package com.mhd_07.compose_training

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.mhd_07.compose_training.ui.theme.JetpackComposeTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTrainingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationContainer(
                        modifier = Modifier.fillMaxSize(),
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationContainer(modifier: Modifier = Modifier, innerPadding: PaddingValues) {
    val backStack = rememberNavBackStack(NavEntries.Splash)
    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<NavEntries.Splash> {
                SplashScreen(modifier = Modifier.fillMaxSize(), onStartClick = {
                    backStack.add(NavEntries.SignIn)
                })
            }
            entry<NavEntries.SignIn> {
                SignInScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding))
            }
        }
    )
}

sealed interface NavEntries : NavKey {
    data object Splash : NavEntries
    data object SignIn : NavEntries
}