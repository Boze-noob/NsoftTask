package com.applid.nsofttask.common.extensions

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun String.toMMDDYY() : String {
    val odt = OffsetDateTime.parse(this)
    val dtf = DateTimeFormatter.ofPattern("MMM dd, uuuu", Locale.ENGLISH)
    return dtf.format(odt)
}