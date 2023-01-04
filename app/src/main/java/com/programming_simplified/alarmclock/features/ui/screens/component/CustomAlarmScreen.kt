package com.programming_simplified.alarmclock.features.ui.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.programming_simplified.alarmclock.R
import com.programming_simplified.alarmclock.common.SpacerHeight
import com.programming_simplified.alarmclock.common.noRippleEffect
import com.programming_simplified.alarmclock.features.model.Weeks
import com.programming_simplified.alarmclock.ui.theme.DarkPink
import com.programming_simplified.alarmclock.ui.theme.LightPink
import com.programming_simplified.alarmclock.utils.EVERYDAY
import com.programming_simplified.alarmclock.utils.RING_ONCE


@Composable
fun CustomAlarmScreen(
    weeks: List<Weeks>,
    tempList: Set<Int>
) {

    var selected by rememberSaveable { mutableStateOf(tempList) }
    var week by remember { mutableStateOf(RING_ONCE) }

    LaunchedEffect(key1 = selected) {
        week = if (selected.size == 7) EVERYDAY else RING_ONCE
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = stringResource(id = R.string.repeat))
            Text(
                text = week, color = DarkPink, modifier = Modifier.padding(top = 3.dp),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            SpacerHeight(20.dp)
            FlowRow(
                mainAxisAlignment = MainAxisAlignment.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                weeks.forEachIndexed { index, week ->
                    CustomWeekSelect(title = week.shortName, selected = selected.contains(index)) {
                        selected = if (selected.contains(index)) {
                            selected.minus(index)
                        } else {
                            selected.plus(index)
                        }
                    }
                }
            }

        }
    }

}

@Composable
fun CustomWeekSelect(
    title: Char,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(elevation = 0.dp, shape = CircleShape, modifier = Modifier
        .size(35.dp)
        .noRippleEffect {
            onClick()
        }) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.background(
                if (selected) DarkPink else LightPink.copy(0.1f)
            )
        ) {
            Text(
                text = title.toString(), style = TextStyle(
                    color = Color.Black,
                    fontSize = 13.sp,
                )
            )
        }
    }

}