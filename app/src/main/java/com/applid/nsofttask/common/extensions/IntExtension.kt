package com.applid.nsofttask.common.extensions

fun Int?.value() : Int {
    if(this == null) return 0
    else return this
}