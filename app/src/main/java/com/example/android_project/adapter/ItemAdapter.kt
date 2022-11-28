package com.example.android_project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel

class ItemAdapter(private val itemListener: ItemListener) : RecyclerView.Adapter<ItemViewHolder>() {

        private var listItem = mutableListOf<ItemsModel>()

        fun submitList(list: List<ItemsModel>){
            this.listItem = list.toMutableList()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fruit,parent,false)
            return ItemViewHolder(view, itemListener)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.bind(listItem[position])

        }

        override fun getItemCount(): Int {
            return 0
        }
    }