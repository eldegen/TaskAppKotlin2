package com.pizza.taskappkotlin2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pizza.taskappkotlin2.data.ShopListRepositoryImpl
import com.pizza.taskappkotlin2.domain.*

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)
    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)

    val shopListLD = MutableLiveData<List<ShopItem>>()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

    fun getShopItem(showItemId: Int): ShopItem {
        return getShopItemUseCase.getShopItem(showItemId)
    }

    fun getShopList(): List<ShopItem> {
        return getShopListUseCase.getShopList()
    }
}
