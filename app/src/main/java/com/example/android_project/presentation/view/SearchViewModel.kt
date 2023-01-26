package com.example.android_project.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.model.ItemsModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val itemsInteractor: ItemInteractor
): ViewModel() {

    private val _item = MutableLiveData<ItemsModel>()
    val item: LiveData<ItemsModel> = _item

    fun findItem(searchText: String) {
        viewModelScope.launch {

            try { val foundItem = itemsInteractor.findItem(searchText)
                _item.value = foundItem

            }catch (e:Exception){
                Log.w("exception", e.toString())
            }



        }
    }
}