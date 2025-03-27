package com.mramallo.cryptotrackerapp.crypto.presentation.coin_list

import com.mramallo.cryptotrackerapp.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction
    data object OnRefresh : CoinListAction
}