package com.pizza.taskappkotlin2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pizza.taskappkotlin2.data.ShopListRepositoryImpl
import com.pizza.taskappkotlin2.domain.AddShopItemUseCase
import com.pizza.taskappkotlin2.domain.GetShopListUseCase
import com.pizza.taskappkotlin2.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)

    val shopListLD = MutableLiveData<List<ShopItem>>()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun getShopList() {
        shopListLD.value = getShopListUseCase.getShopList()
    }

}