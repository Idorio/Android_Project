package com.example.android_project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_project.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor() : ViewModel(){

    private val _items = MutableLiveData<MutableList<ItemsModel>>()
    val items: LiveData<MutableList<ItemsModel>> = _items

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle

    fun getData(){
        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),
            ItemsModel(R.drawable.apple, "Android", "12.25.45"),

            )
        _items.value = listItems.toMutableList()
    }

    fun imageViewClicked(){
        _msg.value = "ImageView clicked"


    }
    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }

    fun userNavigated(){

    }
}



data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)