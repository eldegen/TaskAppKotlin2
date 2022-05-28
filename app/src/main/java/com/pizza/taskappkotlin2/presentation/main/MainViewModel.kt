package com.pizza.taskappkotlin2.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pizza.taskappkotlin2.data.ShopListRepositoryImpl
import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.useCases.*

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)
    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)

    val shopListLD = getShopListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(name = shopItem.name, count = shopItem.count)
        editShopItemUseCase.editShopItem(shopItem)
    }

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    fun getShopItem(showItemId: Int): ShopItem {
        return getShopItemUseCase.getShopItem(showItemId)
    }
}
