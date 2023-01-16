package com.doubleclick.foodresturent.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * Created By Eslam Ghazy on 1/15/2023
 */
class SaveStateViewModel() : ViewModel() {


    private val mapType = MutableLiveData<Boolean>(false)

    fun getType(): Boolean? {
        return mapType.value
    }

    fun setType(type: Boolean) {
         mapType.value = type;
    }


}