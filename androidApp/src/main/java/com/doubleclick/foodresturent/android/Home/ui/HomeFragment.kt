package com.doubleclick.foodresturent.android.Home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentHomeBinding
import com.doubleclick.foodresturent.android.views.imageslider.constants.ScaleTypes
import com.doubleclick.foodresturent.android.views.imageslider.models.SlideModel

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
    }
}