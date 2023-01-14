package com.doubleclick.foodresturent.android.views.imageslider.interfaces

import com.doubleclick.foodresturent.android.views.imageslider.constants.ActionTypes


interface TouchListener {
    /**
     * Click listener touched item function.
     *
     * @param  touched  slider boolean
     */
    fun onTouched(touched: ActionTypes)
}