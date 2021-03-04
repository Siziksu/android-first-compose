package com.siziksu.first_compose.common

import android.util.Log

fun onError(throwable: Throwable) {
    onError(throwable, "APP_LOG", "N/A")
}

fun onError(throwable: Throwable, method: String) {
    onError(throwable, "APP_LOG", method)
}

fun onError(throwable: Throwable, tag: String, method: String) {
    Log.e(tag, "Error in method \"$method\": ${throwable.message}", throwable)
}
