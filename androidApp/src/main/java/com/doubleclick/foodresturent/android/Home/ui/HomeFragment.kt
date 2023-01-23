package com.doubleclick.foodresturent.android.Home.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide.init
import com.doubleclick.foodresturent.android.Adapter.ItemCategory
import com.doubleclick.foodresturent.android.HomeActivity
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentHomeBinding
import com.doubleclick.foodresturent.android.`interface`.OpenSearchView
import com.doubleclick.foodresturent.android.`interface`.itemListener
import com.doubleclick.foodresturent.android.model.ItemCategoryModel
import com.doubleclick.foodresturent.android.views.SimpleSearchView.SimpleSearchView
import com.doubleclick.foodresturent.android.views.SimpleSearchView.utils.DimensUtils.convertDpToPx
import com.doubleclick.foodresturent.android.views.imageslider.constants.ScaleTypes
import com.doubleclick.foodresturent.android.views.imageslider.models.SlideModel
import com.doubleclick.foodresturent.android.views.swipetoactionlayout.utils.show
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), itemListener, OpenSearchView {

    private lateinit var binding: FragmentHomeBinding
    private var isSearch = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.itemRv.adapter = ItemCategory(
            this, listOf(
                ItemCategoryModel("Item 1", 0),
                ItemCategoryModel("Item 2", 1),
                ItemCategoryModel("Item 3", 2),
                ItemCategoryModel("Item 4", 3),
                ItemCategoryModel("Item 5", 4),
                ItemCategoryModel("Item 6", 5),
                ItemCategoryModel("Item 7", 6),
                ItemCategoryModel("Item 8", 7),
                ItemCategoryModel("Item 9", 8),
            )
        );
        binding.imageSlider.setImageList(
            listOf(
                SlideModel(
                    R.drawable.bg,
                    "this it title 1",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.facebook,
                    "this it title 2",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title 3",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.facebook,
                    "this it title 4",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title 5",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.facebook,
                    "this it title 6",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title 7",
                    ScaleTypes.CENTER_CROP
                ),
            )
        )
        binding.fab.setOnClickListener {
            if (isSearch) {
                setupSearchView();
                isSearch = false
            } else {
                searchView.onBackPressed()
                isSearch = true
            }
        }
    }


    private fun setupSearchView() = with(binding) {
        searchView.setMenuItem(this@HomeFragment)
        binding.searchView.setOnQueryTextListener(object : SimpleSearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
//                Toast.makeText(requireContext(), "OnQuery", Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(requireContext(), "Submit $query", Toast.LENGTH_LONG).show()

                return false
            }

            override fun onQueryTextCleared(): Boolean {
                Toast.makeText(requireContext(), "Cleared", Toast.LENGTH_LONG).show()
                return false
            }
        })

        // Adding padding to the animation because of the hidden menu item
        val revealCenter = binding.searchView.revealAnimationCenter
        revealCenter!!.x -= convertDpToPx(40, requireContext())
    }

    override fun mListener(postion: Int) {

    }

    override fun isOpenSearchView(isSearch: Boolean): Boolean {
        this.isSearch = isSearch
        return isSearch;
    }

}