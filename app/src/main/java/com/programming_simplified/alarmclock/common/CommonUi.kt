package com.programming_simplified.alarmclock.common

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@SuppressLint("ModifierParameter")
@Composable
fun CommonIconFromDrawable(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    IconButton(
        onClick = { onClick() }, modifier = modifier.size(24.dp)
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "", tint = tint)
    }

}

@SuppressLint("ModifierParameter")
@Composable
fun CommonIconFromImageVector(
    icon: ImageVector,
    tint: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    IconButton(
        onClick = { onClick() }, modifier = modifier.size(24.dp)
    ) {
        Icon(imageVector = icon, contentDescription = "", tint = tint)
    }

}

@Composable
fun SpacerHeight(
    height: Dp = 10.dp
) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(
    width: Dp = 10.dp
) {
    Spacer(modifier = Modifier.width(width))
}

@SuppressLint("ModifierParameter")
@Composable
fun CommonLine(
    width: Dp = 0.dp,
    height: Dp = 0.dp,
    backgroundColor: Color = Color.LightGray,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .width(width)
            .height(height)
    )
}