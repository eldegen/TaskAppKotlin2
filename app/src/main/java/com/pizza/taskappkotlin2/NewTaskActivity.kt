package com.pizza.taskappkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pizza.taskappkotlin2.databinding.ActivityNewTaskBinding
import com.pizza.taskappkotlin2.domain.models.ShopItem

class NewTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            setResult(RESULT_OK, intent.putExtra("item", ShopItem(binding.edTaskName.text.toString(), binding.edCount.text.toString().toInt(), false)))
            finish()
        }
    }

}