package com.mramallo.cryptotrackerapp.crypto.presentation.coin_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mramallo.cryptotrackerapp.R

@Composable
fun EmptyStateCoinNotSelected(
    contentColor: Color
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = if (isSystemInDarkTheme()) ImageVector.vectorResource(id = R.drawable.empty_coins_dark)
            else ImageVector.vectorResource(id = R.drawable.empty_coins_light),
            contentDescription = "search list",
            modifier = Modifier.size(280.dp),
        )
        Spacer(modifier = Modifier.height(34.dp))
        Text(
            text = stringResource(R.string.empty_state_coin_not_selected_title),
            fontSize = 36.sp,
            color = contentColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.empty_state_coin_not_selected_subtitle),
            fontSize = 20.sp,
            color = contentColor,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center
        )
    }
}