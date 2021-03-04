package com.siziksu.first_compose.ui.common.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val DATE_FORMAT = "dd/MM/yyyy"

fun Long.toDateString(): String {
    val date = Date(this)
    val format = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
    return format.format(date)
}
