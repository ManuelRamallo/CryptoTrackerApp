package com.mramallo.cryptotrackerapp.crypto.presentation.coin_list

import com.mramallo.cryptotrackerapp.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}