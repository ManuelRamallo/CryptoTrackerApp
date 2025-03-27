package com.mramallo.cryptotrackerapp.crypto.domain

import com.mramallo.cryptotrackerapp.core.domain.util.NetworkError
import com.mramallo.cryptotrackerapp.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}