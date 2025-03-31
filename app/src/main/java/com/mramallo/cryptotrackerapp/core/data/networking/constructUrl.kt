package com.mramallo.cryptotrackerapp.core.data.networking

import com.mramallo.cryptotrackerapp.BuildConfig
import com.mramallo.cryptotrackerapp.core.domain.util.API_KEY_ENCRYPTED
import com.mramallo.cryptotrackerapp.core.domain.util.CryptoHelper

fun constructUrl(url: String): String {
    val apiKey = CryptoHelper.decrypt(API_KEY_ENCRYPTED)

    return when {
        url.contains(BuildConfig.BASE_URL) -> "$url?apiKey=$apiKey"
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1) + "?apiKey=$apiKey" // Drop the first char to eliminate the '/'
        else -> BuildConfig.BASE_URL + url + "?apiKey=$apiKey"
    }
}