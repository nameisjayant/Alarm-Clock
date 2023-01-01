package com.programming_simplified.alarmclock.common

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.programming_simplified.alarmclock.ui.theme.DarkPink


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

@SuppressLint("UnnecessaryComposedModifier")
@Composable
fun Modifier.noRippleEffect(onClick: () -> Unit) = composed {
    clickable(
        interactionSource = MutableInteractionSource(), indication = null
    ) {
        onClick()
    }
}

@Composable
fun CheckCircle(
    modifier: Modifier = Modifier
) {

    Card(
        shape = CircleShape, modifier = modifier.size(20.dp), elevation = 0.dp
    ) {
        Box(modifier = Modifier.background(Color.White))
    }

}


@Composable
fun CustomToggleButton(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onUpdate: (Boolean) -> Unit
) {

    Card(
        modifier = modifier
            .width(50.dp)
            .noRippleEffect {
                onUpdate(!selected)
            },
        shape = RoundedCornerShape(16.dp), elevation = 0.dp
    ) {
        Box(
            modifier = Modifier.background(
                if (selected) DarkPink else Color.Gray
            ),
            contentAlignment = if (selected) Alignment.TopEnd else Alignment.TopStart
        ) {
            CheckCircle(modifier = Modifier.padding(5.dp))
        }
    }

}