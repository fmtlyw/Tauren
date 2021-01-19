package com.lyw.module_common_base.ext

import com.sdsmdg.tastytoast.TastyToast

fun infoToast(message: String) {
    AppGlobal.get()
        ?.let { TastyToast.makeText(it, message, TastyToast.LENGTH_LONG, TastyToast.INFO) }
}

fun errorToast(message: String) {
    AppGlobal.get()
        ?.let { TastyToast.makeText(it, message, TastyToast.LENGTH_LONG, TastyToast.ERROR) }
}