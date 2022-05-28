package com.pizza.taskappkotlin2.domain.useCases

import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }

}