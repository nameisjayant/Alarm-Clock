package com.programming_simplified.alarmclock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.programming_simplified.alarmclock.alarm_manager.AlarmReceiver
import com.programming_simplified.alarmclock.features.ui.screens.HomeScreen
import com.programming_simplified.alarmclock.ui.theme.AlarmClockTheme
import com.programming_simplified.alarmclock.ui.theme.Background

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, AlarmReceiver::class.java)
            intent.action = "MyBroadcastReceiverAction"
            val pendingIntent =
                PendingIntent.getBroadcast(
                    this, 0, intent, PendingIntent.FLAG_IMMUTABLE
                )
            val msUntilTriggerHour: Long = 10000
            val alarmTimeAtUTC: Long = System.currentTimeMillis() + msUntilTriggerHour

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                alarmManager.setAlarmClock(
                    AlarmManager.AlarmClockInfo(alarmTimeAtUTC, pendingIntent),
                    pendingIntent
                )
            } else {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    alarmTimeAtUTC,
                    pendingIntent
                )
            }

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
