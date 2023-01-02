package com.programming_simplified.alarmclock.features.ui.screens.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.programming_simplified.alarmclock.ui.theme.DarkPink


@Composable
fun HoursNumberPickerScreen() {
    var state by remember { mutableStateOf<Hours>(FullHours(12, 43)) }
    HoursNumberPicker(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        leadingZero = true,
        dividersColor = DarkPink.copy(0.4f),
        value = state,
        onValueChange = {
            state = it
        },
        hoursDivider = {
            Text(
                modifier = Modifier.size(24.dp),
                textAlign = TextAlign.Center,
                text = ":"
            )
        },
    )
}