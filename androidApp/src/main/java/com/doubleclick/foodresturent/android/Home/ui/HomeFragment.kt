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
import com.doubleclick.foodresturent.android.HomeActivity
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentHomeBinding
import com.doubleclick.foodresturent.android.views.SimpleSearchView.SimpleSearchView
import com.doubleclick.foodresturent.android.views.SimpleSearchView.utils.DimensUtils.convertDpToPx
import com.doubleclick.foodresturent.android.views.imageslider.constants.ScaleTypes
import com.doubleclick.foodresturent.android.views.imageslider.models.SlideModel
import com.doubleclick.foodresturent.android.views.swipetoactionlayout.utils.show
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
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
        binding.imageSlider.setImageList(
            listOf(
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
                SlideModel(
                    R.drawable.bg,
                    "this it title",
                    ScaleTypes.CENTER_CROP
                ),
            )
        )
        setupSearchView();
    }


    private fun setupSearchView() = with(binding) {
        binding.searchView.show(true)
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

}