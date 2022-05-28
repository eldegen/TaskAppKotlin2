package com.pizza.taskappkotlin2.domain

import androidx.lifecycle.LiveData
import com.pizza.taskappkotlin2.domain.models.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    // TODO: Может быть изменен
    fun getShopList(): LiveData<List<ShopItem>>

}