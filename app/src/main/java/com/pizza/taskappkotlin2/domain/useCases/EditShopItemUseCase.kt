package com.pizza.taskappkotlin2.domain.useCases

import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }

}