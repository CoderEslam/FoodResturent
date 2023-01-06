package com.doubleclick.foodresturent.android.views.swipetoactionlayout

import android.view.View
import com.doubleclick.foodresturent.android.views.swipetoactionlayout.SwipeAction

interface SwipeMenuListener {
    fun onClosed(view: View)
    fun onOpened(view: View)
    fun onFullyOpened(view: View, quickAction: SwipeAction)

    fun onActionClicked(view: View, action: SwipeAction)
}
