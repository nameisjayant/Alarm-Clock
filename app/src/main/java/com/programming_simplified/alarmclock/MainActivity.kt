package com.programming_simplified.alarmclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.programming_simplified.alarmclock.features.ui.screens.HomeScreen
import com.programming_simplified.alarmclock.ui.theme.AlarmClockTheme
import com.programming_simplified.alarmclock.ui.theme.Background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmClockTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
