package com.doubleclick.foodresturent.android.views.swipetoactionlayout.behaviour

import android.view.View
import com.doubleclick.foodresturent.android.views.swipetoactionlayout.QuickActionsStates
import com.doubleclick.foodresturent.android.views.swipetoactionlayout.utils.Size

internal interface BehaviourDelegate {

    fun layoutAction(view: View, l: Int, r: Int, actionSize: Size)

    fun clampViewPosition(parentView: View, view: View, left: Int, actionSize: Size): Int

    fun translateAction(mainView: View, actionView: View, actionSize: Size, dx: Int, index: Int)

    fun isOpened(position: Int, actionSize: Size): Boolean

    fun getFinalLeftPosition(view: View, velocity: Float, actionSize: Size): Int

    fun getStateForPosition(view: View, actionSize: Size): QuickActionsStates

    fun getPositionForState(view: View, actionSize: Size, states: QuickActionsStates): Int

}