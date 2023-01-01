package com.programming_simplified.alarmclock.features.ui.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming_simplified.alarmclock.common.CommonIconFromImageVector
import com.programming_simplified.alarmclock.common.SpacerHeight


@Composable
fun BottomSheetContents(
    alarmType: String,
    onCancel: () -> Unit,
    onCheck: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp, top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CommonIconFromImageVector(icon = Icons.Rounded.Close, tint = Color.Black) {
                        onCancel()
                    }
                    Text(
                        text = alarmType,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    CommonIconFromImageVector(icon = Icons.Rounded.Check, tint = Color.Black) {
                        onCheck()
                    }
                }
            }
            item {
                SpacerHeight(20.dp)
                HoursNumberPickerScreen()
            }

        }
    }


}