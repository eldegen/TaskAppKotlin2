package com.pizza.taskappkotlin2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pizza.taskappkotlin2.domain.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository
import java.lang.RuntimeException

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({
        e1, e2 -> e1.id.compareTo(e2.id)
    })
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)

        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)

        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldItem = getShopItem(shopItem.id)
        shopList.remove(oldItem)
        addShopItem(shopItem)

        updateList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { item ->
            item.id == shopItemId
        } ?: throw RuntimeException("can't find an item by id ($shopItemId). it doesn't exists")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }

}