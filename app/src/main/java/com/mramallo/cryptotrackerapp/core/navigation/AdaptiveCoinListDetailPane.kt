@file:OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3AdaptiveApi::class)

package com.mramallo.cryptotrackerapp.core.navigation

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mramallo.cryptotrackerapp.core.presentation.util.ObserveAsEvents
import com.mramallo.cryptotrackerapp.core.presentation.util.toString
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_detail.CoinDetailScreen
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_detail.components.EmptyStateCoinNotSelected
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_list.CoinListAction
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_list.CoinListEvent
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_list.CoinListScreen
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_list.CoinListViewModel
import com.mramallo.cryptotrackerapp.crypto.presentation.coin_list.components.EmptyStateList
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun AdaptiveCoinListDetailPane(
    modifier: Modifier = Modifier,
    viewModel: CoinListViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    ObserveAsEvents(events = viewModel.events) { event ->
        when (event) {
            is CoinListEvent.Error -> {
                Toast.makeText(
                    context,
                    event.error.toString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()
    val coroutineScope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current

    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                if (state.coins.isEmpty() && !state.isLoading
                    && configuration.orientation == Configuration.ORIENTATION_PORTRAIT
                ) {
                    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                    EmptyStateList(
                        modifier = modifier,
                        contentColor = contentColor,
                        isLandScape = false,
                        onRefresh = {
                            coroutineScope.launch {
                                viewModel.onAction(CoinListAction.OnRefresh)
                            }
                        }
                    )
                } else {
                    CoinListScreen(
                        state = state,
                        onAction = { action ->
                            viewModel.onAction(action)
                            when (action) {
                                is CoinListAction.OnCoinClick -> {
                                    coroutineScope.launch {
                                        navigator.navigateTo(
                                            pane = ListDetailPaneScaffoldRole.Detail,
                                        )
                                    }
                                }

                                is CoinListAction.OnRefresh -> {} // No operation needed here
                            }
                        }
                    )
                }
            }
        },
        detailPane = {
            val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
            if (state.coins.isEmpty() && !state.isLoading) {
                EmptyStateList(
                    modifier = modifier,
                    contentColor = contentColor,
                    isLandScape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE,
                    onRefresh = {
                        coroutineScope.launch {
                            viewModel.onAction(CoinListAction.OnRefresh)
                        }
                    }
                )
            } else if (state.selectedCoin != null) {
                AnimatedPane {
                    CoinDetailScreen(state = state)
                }
            } else {
                EmptyStateCoinNotSelected(
                    contentColor = contentColor
                )
            }

        },
        modifier = modifier
    )
}
