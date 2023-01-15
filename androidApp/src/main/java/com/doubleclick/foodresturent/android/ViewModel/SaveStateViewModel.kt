package com.doubleclick.foodresturent.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * Created By Eslam Ghazy on 1/15/2023
 */
class SaveStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {


    private val liveData = savedStateHandle.getLiveData("mapType", false)

    fun saveState() {
        savedStateHandle["mapType"] = liveData.value
    }


}