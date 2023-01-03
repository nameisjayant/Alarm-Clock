package com.programming_simplified.alarmclock.features.ui.screens.component

import android.hardware.lights.Light
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming_simplified.alarmclock.R
import com.programming_simplified.alarmclock.common.CommonIconFromImageVector
import com.programming_simplified.alarmclock.common.CustomChip
import com.programming_simplified.alarmclock.common.CustomToggleButton
import com.programming_simplified.alarmclock.common.SpacerHeight
import com.programming_simplified.alarmclock.features.model.listOfWeeks
import com.programming_simplified.alarmclock.ui.theme.Background
import com.programming_simplified.alarmclock.ui.theme.DarkPink
import com.programming_simplified.alarmclock.ui.theme.LightPink
import com.programming_simplified.alarmclock.utils.CUSTOM
import com.programming_simplified.alarmclock.utils.RING_ONCE


@Composable
fun BottomSheetContents(
    alarmType: String, onCancel: () -> Unit, onCheck: () -> Unit
) {

    var chipState by remember { mutableStateOf(RING_ONCE) }
    val chipList = listOf(RING_ONCE, CUSTOM)
    val weeks = listOfWeeks
    val tempList: Set<Int> = emptySet()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightPink.copy(0.1f))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
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
                        text = alarmType, style = TextStyle(
                            color = Color.Black, fontSize = 17.sp, fontWeight = FontWeight.SemiBold
                        )
                    )
                    CommonIconFromImageVector(icon = Icons.Rounded.Check, tint = Color.Black) {
                        onCheck()
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    contentAlignment = Center
                ) {
                    Text(
                        text = "Ring in 1 day",
                        style = TextStyle(
                            color = Color.DarkGray.copy(0.7f),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }
                SpacerHeight(15.dp)
                HoursNumberPickerScreen()
            }

            item {
                SpacerHeight(20.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    chipList.forEach {
                        CustomChip(
                            label = it,
                            selected = it == chipState,
                        ) { state ->
                            chipState = state
                        }
                    }
                }
            }

            if (chipState == CUSTOM) item {
                CustomAlarmScreen(weeks, tempList)
            }
            item {
                AlarmSetting()
            }
        }
    }
}

@Composable
fun AlarmSetting() {

    var alarmName by remember { mutableStateOf("") }
    var isVibrated by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {

            TextField(value = alarmName,
                onValueChange = { alarmName = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = DarkPink,
                    unfocusedIndicatorColor = Color.LightGray.copy(0.4f),
                ),
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = stringResource(R.string.alarm_name), style = TextStyle(
                            fontWeight = FontWeight.Normal, color = Color.Gray.copy(0.7f)
                        )
                    )
                })
            SpacerHeight(15.dp)

            SettingRow(title = stringResource(R.string.ringtone), des = "Holiday")
            SpacerHeight(10.dp)
            VibrateRow(selected = isVibrated, onSelected = { isVibrated = it })
            SpacerHeight(10.dp)
            SettingRow(title = stringResource(R.string.snooze), des = "5 minutes,3 minutes")

        }
    }

}

@Composable
fun SettingRow(
    title: String, des: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = title, style = TextStyle(
                    fontSize = 15.sp, fontWeight = FontWeight.Normal, color = Color.Black
                )
            )
            Text(
                text = des, modifier = Modifier.padding(top = 3.dp), style = TextStyle(
                    color = DarkPink, fontSize = 10.sp, fontWeight = FontWeight.Normal
                )
            )
        }
        CommonIconFromImageVector(
            icon = Icons.Rounded.ArrowForwardIos,
            modifier = Modifier
                .align(CenterVertically)
                .size(16.dp),
            tint = DarkPink,
        ) {

        }
    }

}

@Composable
fun VibrateRow(
    selected: Boolean, onSelected: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.vibrate), style = TextStyle(
                fontSize = 15.sp, fontWeight = FontWeight.Normal, color = Color.Black
            ), modifier = Modifier.align(CenterVertically)
        )
        CustomToggleButton(selected = selected, onUpdate = { onSelected(it) })
    }

}