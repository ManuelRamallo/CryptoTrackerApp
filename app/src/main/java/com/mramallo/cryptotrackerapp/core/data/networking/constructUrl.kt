package com.mramallo.cryptotrackerapp.core.data.networking

import com.mramallo.cryptotrackerapp.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1) // Drop the first char to eliminate the '/'
        else -> BuildConfig.BASE_URL + url
    }
}