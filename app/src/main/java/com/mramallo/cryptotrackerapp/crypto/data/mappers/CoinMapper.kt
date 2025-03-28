package com.mramallo.cryptotrackerapp.crypto.data.mappers

import com.mramallo.cryptotrackerapp.crypto.data.networking.dto.CoinDto
import com.mramallo.cryptotrackerapp.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        symbol = symbol,
        name = name,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
        explorer = explorer ?: ""
    )
}