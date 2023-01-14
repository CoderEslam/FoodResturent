package com.doubleclick.foodresturent.android.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.foodresturent.android.R

/**
 * Created By Eslam Ghazy on 1/14/2023
 */
class AddressAdapter : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {

        return AddressViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_location, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}