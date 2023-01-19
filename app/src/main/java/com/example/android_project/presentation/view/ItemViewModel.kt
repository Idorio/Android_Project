package com.example.android_project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemInteractor: ItemInteractor
) : ViewModel(){

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle

    private val _error = MutableLiveData<String>()
    val erq: LiveData<String> = _error

   fun getData(){
       viewModelScope.launch {
           try {
               _items.value = itemInteractor.getData()
           }catch (e : Exception){
               _error.value = "Error"
           }
       }
   }
    fun imageViewClicked(){
        _msg.value = "ImageView clicked"

    }
    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView,
            destinationId = R.id.action_itemsFragment_to_detailsFragment
        )
    }

    fun userNavigated(){

    }
}



data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String,
    val destinationId: Int
)