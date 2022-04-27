package com.pizza.taskappkotlin2.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    // TODO: Может быть изменен
    fun getShopList(): List<ShopItem>

}