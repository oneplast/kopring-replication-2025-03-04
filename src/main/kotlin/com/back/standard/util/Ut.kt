package com.back.standard.util

import java.util.*

object Ut {
    object str {
        fun lcfirst(str: String): String {
            return str.substring(0, 1).lowercase(Locale.getDefault()) + str.substring(1)
        }
    }
}