package com.pizza.taskappkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.pizza.taskappkotlin2.databinding.ActivityMainBinding
import com.pizza.taskappkotlin2.domain.ShopItem
import com.pizza.taskappkotlin2.extension.showToast
import com.pizza.taskappkotlin2.presentation.MainViewModel
import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "bruh"
    }

    private lateinit var viewModel: MainViewModel
    private var bufferShopList = listOf<ShopItem>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObservers()
        initListeners()
    }

    private fun initObservers() {
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

    private fun initListeners() {
        binding.btnAddItem.setOnClickListener {
            viewModel.addShopItem(ShopItem(binding.editText.text.toString(), 2, false))
            showToast("Added")
        }

        binding.btnDeleteItem.setOnClickListener {
            try {
                viewModel.deleteShopItem(ShopItem("", 0, false, 0))
                showToast("Deleted")
            } catch (e: IndexOutOfBoundsException) {
                showToast("Nothing to delete")
            }
        }

        binding.btnEditItem.setOnClickListener {
            viewModel.editShopItem(ShopItem(binding.editText.text.toString(), 2, false, 0))
            showToast("Edited")
        }

        binding.btnGetItem.setOnClickListener {
            try {
                try {
                    showToast(viewModel.getShopItem(Integer.valueOf(binding.editText.text.toString())).toString())
                } catch (e: NumberFormatException) {
                    showToast("Dude, it's not a number")
                }
            } catch (e: IndexOutOfBoundsException) {
                showToast("Incorrect index!")
            }
        }

        binding.btnGetList.setOnClickListener {
            viewModel.getShopList()
            showToast("Check your logs \n P.S: Tag: bruh")
            Log.d(TAG, "List: \n ${viewModel.getShopList()}")
        }
    }
}