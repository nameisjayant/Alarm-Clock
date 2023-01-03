package com.programming_simplified.alarmclock.features.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming_simplified.alarmclock.R
import com.programming_simplified.alarmclock.common.CommonIconFromImageVector
import com.programming_simplified.alarmclock.common.SpacerHeight
import com.programming_simplified.alarmclock.features.ui.screens.component.AlarmEachRow
import com.programming_simplified.alarmclock.features.ui.screens.component.BottomSheetContents
import com.programming_simplified.alarmclock.ui.theme.DarkPink
import com.programming_simplified.alarmclock.ui.theme.Background
import com.programming_simplified.alarmclock.ui.theme.LightPink
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(sheetState = sheetState, sheetContent = {
        BottomSheetContents(alarmType = stringResource(R.string.new_alarm), onCancel = {
            scope.launch {
                scope.launch {
                    sheetState.animateTo(
                        ModalBottomSheetValue.Hidden, anim = tween(
                            durationMillis = 700,
                            delayMillis = 0
                        )
                    )
                }
            }
        }) {

        }
    }, sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            sheetState.animateTo(
                                ModalBottomSheetValue.Expanded, anim = tween(
                                    durationMillis = 700,
                                    delayMillis = 0
                                )
                            )
                        }
                    }, backgroundColor = DarkPink, modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        Icons.Rounded.Add, contentDescription = "", tint = Color.White
                    )
                }
            },
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LightPink.copy(0.1f))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {

                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd
                        ) {
                            CommonIconFromImageVector(
                                icon = Icons.Rounded.MoreVert,
                                tint = DarkPink,
                                modifier = Modifier.padding(top = 13.dp)
                            ) {}
                        }
                    }
                    item {
                        SpacerHeight(15.dp)
                    }
                    item {
                        Text(
                            text = stringResource(R.string.alarm), style = TextStyle(
                                color = Color.Black,
                                fontSize = 38.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                    items(3) {
                        AlarmEachRow()
                    }

                }
            }

        }
    }

}

