package com.example.android_project.presentation.adapter


import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.databinding.ItemFruitBinding
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel


class ItemViewHolder(
    private val viewBinding: ItemFruitBinding,
    private val itemListener: ItemListener
    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemModel: ItemsModel) {

        viewBinding.tvName.text = itemModel.name
        viewBinding.ivName.setBackgroundResource(itemModel.image)
        viewBinding.tvDate.text = itemModel.date


        itemView.setOnClickListener{
            itemListener.onElementSelected(itemModel.name, itemModel.date,itemModel.image)
        }

    }
}