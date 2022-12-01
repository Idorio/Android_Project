package com.example.android_project.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel


class ItemViewHolder(
    private val view: View,
    private val itemListener: ItemListener
    ) : RecyclerView.ViewHolder(view) {

    fun bind(itemModel: ItemsModel) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val imageView = view.findViewById<ImageView>(R.id.iv_name)
        val date = view.findViewById<TextView>(R.id.tv_date)

        name.text = itemModel.name
        imageView.setBackgroundResource(itemModel.image)
        date.text = itemModel.date

        imageView.setOnClickListener{
            itemListener.onClick()
        }
        itemView.setOnClickListener{
            itemListener.onElementSelected(itemModel.name, itemModel.date,itemModel.image)
        }

    }
}