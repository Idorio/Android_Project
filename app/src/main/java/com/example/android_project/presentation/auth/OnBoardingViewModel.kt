package com.example.android_project.presentation.auth
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_project.R

class OnBoardingViewModel : ViewModel() {
    private val _nav = MutableLiveData<navToItems?>()
    val nav: LiveData<navToItems?> = _nav

    val onBoardingText = MutableLiveData<String>()

    fun onBtnClick() {
        _nav.value = navToItems(R.id.action_onBoardingFragment_to_itemsFragment, R.id.onBoardingFragment)
    }

    fun onBoardingBack() {
        _nav.value = null
    }
}

data class navToItems(
    val destinationId: Int,
    val removeFragmentId: Int

)

