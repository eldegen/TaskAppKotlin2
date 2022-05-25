package com.pizza.taskappkotlin2.data

import com.pizza.taskappkotlin2.domain.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.removeAt(shopItem.id)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopList[0] = shopItem
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList[shopItemId]
    }

    override fun getShopList(): List<ShopItem> = shopList.toList()


}