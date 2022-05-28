package com.pizza.taskappkotlin2.presentation.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pizza.taskappkotlin2.databinding.ItemTaskBinding
import com.pizza.taskappkotlin2.domain.models.ShopItem

class SecondAdapter(private var items: ArrayList<ShopItem>) : RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondAdapter.ViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    var onItemClick: ((ShopItem) -> Unit)? = null

    override fun onBindViewHolder(holder: SecondAdapter.ViewHolder, position: Int) {
        val shopItem = items[position]

        with(holder) {
            binding.tvTask.text = items[position].name
            binding.tvCount.text = items[position].count.toString()
            binding.itemTask.setOnClickListener {
                onItemClick?.invoke(shopItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // My methods

    fun updateList(newList: List<ShopItem>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }

}