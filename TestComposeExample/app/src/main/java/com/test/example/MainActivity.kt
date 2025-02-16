package com.test.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.test.example.ui.theme.TestComposeExampleTheme
import com.test.example.ui.theme.ThemeSideEffect
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val startTime = System.currentTimeMillis()
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition { false }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showSplashScreen by remember { mutableStateOf(true) }
            TestComposeExampleTheme {
                LaunchedEffect(showSplashScreen) {
                    if (showSplashScreen) {
                        val elapsed = System.currentTimeMillis() - startTime
                        val delayTime = maxOf(0, 3000 - elapsed)
                        delay(delayTime)
                        showSplashScreen = false
                    }
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (showSplashScreen) {
                        SplashScreen()
                    } else {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SplashScreen() {
    val color = Color(0xFF1034A6)

    ThemeSideEffect(
        statusBarColor = color,
        navigationBarColor = color,
    )
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val color = Color(0xFFFFFFFF)

    ThemeSideEffect(
        statusBarColor = color,
        navigationBarColor = color,
    )
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestComposeExampleTheme {
        Greeting("Android")
    }
}