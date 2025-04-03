package com.mramallo.cryptotrackerapp.crypto.data.mappers

import com.mramallo.cryptotrackerapp.crypto.data.networking.dto.CoinDto
import com.mramallo.cryptotrackerapp.crypto.data.networking.dto.CoinPriceDto
import com.mramallo.cryptotrackerapp.crypto.domain.Coin
import com.mramallo.cryptotrackerapp.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank ?: 0,
        symbol = symbol ?: "",
        name = name ?: "",
        marketCapUsd = marketCapUsd ?: 0.0,
        priceUsd = priceUsd ?: 0.0,
        changePercent24Hr = changePercent24Hr ?: 0.0,
        explorer = explorer ?: ""
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.of("UTC"))
    )
}