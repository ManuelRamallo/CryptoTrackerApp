package com.mramallo.cryptotrackerapp.core.data.networking

import com.mramallo.cryptotrackerapp.BuildConfig

fun constructUrl(url: String): String {
    val apiKey = BuildConfig.API_KEY

    return when {
        url.contains(BuildConfig.BASE_URL) -> "$url?apiKey=$apiKey"
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1) + "?apiKey=$apiKey" // Drop the first char to eliminate the '/'
        else -> BuildConfig.BASE_URL + url + "?apiKey=$apiKey"
    }
}