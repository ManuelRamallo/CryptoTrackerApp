package com.mramallo.cryptotrackerapp.crypto.data.networking

import com.mramallo.cryptotrackerapp.core.data.networking.constructUrl
import com.mramallo.cryptotrackerapp.core.data.networking.safeCall
import com.mramallo.cryptotrackerapp.core.domain.util.NetworkError
import com.mramallo.cryptotrackerapp.core.domain.util.Result
import com.mramallo.cryptotrackerapp.core.domain.util.map
import com.mramallo.cryptotrackerapp.crypto.data.mappers.toCoin
import com.mramallo.cryptotrackerapp.crypto.data.networking.dto.CoinsResponseDto
import com.mramallo.cryptotrackerapp.crypto.domain.Coin
import com.mramallo.cryptotrackerapp.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}