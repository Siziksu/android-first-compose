package com.siziksu.port.common

import android.util.Log

fun log(string: String) {
    log("APP_LOG", string)
}

fun log(tag: String, string: String) {
    Log.d(tag, string)
}

fun info(string: String) {
    info("APP_LOG", string)
}

fun info(tag: String, string: String) {
    Log.i(tag, string)
}

fun verbose(string: String) {
    verbose("APP_LOG", string)
}

fun verbose(tag: String, string: String) {
    Log.v(tag, string)
}

fun onError(throwable: Throwable) {
    onError(throwable, "APP_LOG", "N/A")
}

fun onError(throwable: Throwable, method: String) {
    onError(throwable, "APP_LOG", method)
}

fun onError(throwable: Throwable, tag: String, method: String) {
    Log.e(tag, "Error in method \"$method\": ${throwable.message}", throwable)
}
