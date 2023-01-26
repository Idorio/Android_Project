package com.example.android_project.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.databinding.ItemFruitBinding
import com.example.android_project.domain.lister.ItemListener
import com.example.android_project.model.ItemsModel

class FavouriteItemAdapter(private val itemListener: ItemListener): RecyclerView.Adapter<ItemViewHolder>() {

    private var listItem = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>) {
        this.listItem.clear()
        this.listItem = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ItemViewHolder(viewBinding, itemListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(listItem[position])

    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}