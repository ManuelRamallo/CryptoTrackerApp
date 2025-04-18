package com.mramallo.cryptotrackerapp.crypto.presentation.coin_detail

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

data class ChartStyle(
    val charLineColor: Color,
    val unselectedColor: Color,
    val selectedColor: Color,
    val helperLinesThicknessPx: Float,
    val axisLinesThicknessPx: Float,
    val labelFontSize: TextUnit,
    val minYLabelSpacingDp: Dp,
    val verticalPadding: Dp,
    val horizontalPadding: Dp,
    val xAxisLabelSpacing: Dp,
)
