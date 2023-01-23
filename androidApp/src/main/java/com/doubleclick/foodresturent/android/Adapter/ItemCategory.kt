package com.doubleclick.foodresturent.android.Adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.`interface`.itemListener
import com.doubleclick.foodresturent.android.model.ItemCategoryModel


/**
 * Created By Eslam Ghazy on 1/21/2023
 */
class ItemCategory(itemListener: itemListener, itemCategoryModel: List<ItemCategoryModel>) :
    RecyclerView.Adapter<ItemCategory.ItemCategoryViewHolder>() {

    private var lastCheckedPosition = -1
    var itemListener: itemListener
    var itemCategoryModel: List<ItemCategoryModel>

    init {
        this.itemListener = itemListener
        this.itemCategoryModel = itemCategoryModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        return ItemCategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category_rv,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemCategoryModel.size;
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {

        initializeViews(itemCategoryModel[position], holder);
    }

    class ItemCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCategory: TextView =
            itemView.findViewById(R.id.text_category);
        val cardCategory: CardView =
            itemView.findViewById(R.id.card_category);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initializeViews(model: ItemCategoryModel, holder: RecyclerView.ViewHolder) {
        (holder as ItemCategoryViewHolder).textCategory.text = model.name
        if (model.id == lastCheckedPosition) {
            val img: Drawable =
                holder.itemView.context.resources.getDrawable(R.drawable.ic_close_black_24dp)
            img.setBounds(0, 0, 24, 24)
            holder.textCategory.setCompoundDrawables(
                img,
                null,
                null,
                null
            )
            holder.textCategory.setTextColor(
                holder.itemView.context.resources.getColor(
                    R.color.white
                )
            )
            holder.cardCategory.setCardBackgroundColor(
                holder.itemView.context.resources.getColor(
                    R.color.red
                )
            )
        } else {
            val img: Drawable =
                holder.itemView.context.resources.getDrawable(R.drawable.ic_close_black_24dp)
            img.setBounds(0, 0, 0, 0)
            (holder as ItemCategoryViewHolder).textCategory.setCompoundDrawables(
                null,
                null,
                null,
                null
            )
            holder.cardCategory.setCardBackgroundColor(
                holder.itemView.context.resources.getColor(
                    R.color.yellow
                )
            )

//            ((ItemCourseViewHolder) holder).check.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            itemListener.mListener(model.id)
            lastCheckedPosition = model.id
            notifyItemRangeChanged(0, itemCategoryModel.size)
        })
    }

}