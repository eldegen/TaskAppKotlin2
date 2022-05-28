package com.pizza.taskappkotlin2.domain.models

import java.io.Serializable

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) : Serializable {
    companion object {
        const val UNDEFINED_ID = -1
    }
}