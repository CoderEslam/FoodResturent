package com.doubleclick.foodresturent.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doubleclick.foodresturent.android.databinding.ActivityMainBinding
import com.doubleclick.foodresturent.android.liquidswipe.CustomFragmentPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        binding.viewpager.adapter = CustomFragmentPagerAdapter(supportFragmentManager)
    }
}

