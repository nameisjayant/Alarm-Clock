package com.programming_simplified.alarmclock.features.ui.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming_simplified.alarmclock.common.CommonLine


@Composable
fun AlarmEachRow() {

    var isToggle by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "07:00", style = TextStyle(
                            color = Color.Black, fontSize = 35.sp, fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Ring Once", style = TextStyle(
                            color = Color.Gray, fontSize = 13.sp, fontWeight = FontWeight.Normal
                        )
                    )
                }
                Row(
                    modifier = Modifier.align(CenterVertically)
                ) {
                    CommonLine(
                        width = 0.5.dp,
                        height = 20.dp,
                        modifier = Modifier.align(CenterVertically)
                    )
                    IconToggleButton(checked = isToggle, onCheckedChange = {
                        isToggle = it
                    }, modifier = Modifier.padding(start = 15.dp)) {
                        Text(text = "check", color = Color.Black)
                    }
                }
            }

        }
    }

}