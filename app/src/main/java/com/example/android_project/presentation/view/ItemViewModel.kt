package com.example.android_project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.model.ItemsModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsViewModel @Inject constructor(
    private val itemInteractor: ItemInteractor
) : ViewModel() {


    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    fun showData(){
        viewModelScope.launch {
            try {
                itemInteractor.getData()
                _items.value = itemInteractor.showData()
            }catch (e: Exception){
                _error.value= e.message
            }
        }
    }


    val getData = flow { emit(itemInteractor.getData()) }

    private val _trigger = MutableLiveData<Flow<Unit>>()
    val trigger = _trigger

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    suspend fun getDataSimple(){
        itemInteractor.getData()
    }

    fun getData() {
        viewModelScope.launch {
            viewModelScope.launch {
                _trigger.value = flow { emit(itemInteractor.getData()) }
            }
        }
    }
    suspend fun deleteItem(description: String) {
        viewModelScope.launch {
            itemInteractor.deleteItemByDescription(description)
        }
    }
        fun imageViewClicked() {
            _msg.value = R.string.button
        }
        fun elementClicked(description: String, image: String) {
            _bundle.value =
                NavigateWithBundle(image, R.id.action_itemsFragment_to_detailsFragment, description)
        }
        fun userNavigated() {
            _bundle.value = null
        }
}
data class NavigateWithBundle(
    val image: String,
    val destinationId: Int,
    val description: String
)