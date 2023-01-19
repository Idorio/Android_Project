package com.example.android_project.presentation.adapter


import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.databinding.ItemFruitBinding
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel
import com.squareup.picasso.Picasso


class ItemViewHolder(
    private val viewBinding: ItemFruitBinding,
    private val itemListener: ItemListener
    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemModel: ItemsModel) {

        viewBinding.tvName.text = itemModel.description
        Picasso.get().load(Uri.parse(itemModel.imageUrl)).into(viewBinding.ivName)
//        viewBinding.ivName.setBackgroundResource(itemModel.image)
//        viewBinding.tvDate.text = itemModel.date


        itemView.setOnClickListener{
            itemListener.onClick()
        }
        itemView.setOnClickListener{
            itemListener.onElementSelected(
                itemModel.description,
                "itemsModel.date",
                0
            )
        }
    }
}