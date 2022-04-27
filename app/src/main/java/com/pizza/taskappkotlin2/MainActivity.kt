package com.pizza.taskappkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pizza.taskappkotlin2.domain.ShopItem
import com.pizza.taskappkotlin2.presentation.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initObservers()
    }

    private fun initObservers() {
        viewModel.getShopList()

        // Get shopList
        viewModel.shopListLD.observe(this) {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }

        // Add shopItem
        viewModel.addShopItem(ShopItem("potato", 2, true))
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}