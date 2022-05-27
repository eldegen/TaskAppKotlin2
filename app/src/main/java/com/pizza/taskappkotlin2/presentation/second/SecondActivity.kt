package com.pizza.taskappkotlin2.presentation.second

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.pizza.taskappkotlin2.NewTaskActivity
import com.pizza.taskappkotlin2.databinding.ActivitySecondBinding
import com.pizza.taskappkotlin2.domain.ShopItem
import com.pizza.taskappkotlin2.presentation.main.MainViewModel

class SecondActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivitySecondBinding
    private lateinit var adapter: SecondAdapter

    private var bufferShopList = arrayListOf<ShopItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObservers()
        initAdapter()
        initListeners()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initObservers() {
        // Add shopItem
        viewModel.addShopItem(ShopItem("potato", 2, true))

        // Get shopList
        viewModel.shopListLD.observe(this) {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            bufferShopList.addAll(it)
        }
    }

    private fun initAdapter() {
        adapter = SecondAdapter(bufferShopList)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun initListeners() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, NewTaskActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private var resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Log.e("bruh", "got data")
            val data: Intent? = result.data

            if (data != null) {
                viewModel.addShopItem(data.getSerializableExtra("item") as ShopItem)
                adapter.updateList(bufferShopList)
            }
        }
    }

}