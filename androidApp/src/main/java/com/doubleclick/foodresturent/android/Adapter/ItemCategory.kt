package com.doubleclick.foodresturent.android.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.foodresturent.android.R

/**
 * Created By Eslam Ghazy on 1/21/2023
 */
class ItemCategory : RecyclerView.Adapter<ItemCategory.ItemCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        return ItemCategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category_rv, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 20;
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {

    }

    class ItemCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}