package com.mramallo.cryptotrackerapp.core.data.networking

import com.mramallo.cryptotrackerapp.BuildConfig

fun constructUrl(url: String): String {
    val apiKey = "16849969093ccc2652c065c4a0cf6e4e1ef545e53579e930d84693d020390e70"
    return when {
        url.contains(BuildConfig.BASE_URL) -> "$url?apiKey=$apiKey"
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1) + "?apiKey=$apiKey"// Drop the first char to eliminate the '/'
        else -> BuildConfig.BASE_URL + url + "?apiKey=$apiKey"
    }
}