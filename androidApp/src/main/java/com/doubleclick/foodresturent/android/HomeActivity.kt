package com.doubleclick.foodresturent.android

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.doubleclick.foodresturent.android.databinding.ActivityHomeBinding
import androidx.navigation.ui.setupActionBarWithNavController
import com.doubleclick.foodresturent.android.databinding.NoInternetConnectionBinding
import com.doubleclick.foodresturent.android.utils.isNetworkConnected
import com.doubleclick.foodresturent.android.views.curvedBottomNavigation.CbnMenuItem

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var networkBinding: NoInternetConnectionBinding


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isNetworkConnected(this)) {
            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)
        } else {
            networkBinding = NoInternetConnectionBinding.inflate(layoutInflater)
            setContentView(networkBinding.root)
        }


        val activeIndex = savedInstanceState?.getInt("activeIndex") ?: 2

        val navController = findNavController(R.id.nav_home_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_cart,
                R.id.navigation_layout,
                R.id.navigation_profile,
                R.id.navigation_favorite
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.favorite,
                R.drawable.favorite,
                R.id.navigation_favorite
            ),
            CbnMenuItem(
                R.drawable.location,
                R.drawable.location,
                R.id.navigation_location
            ),
            CbnMenuItem(
                R.drawable.home,
                R.drawable.home,
                R.id.navigation_home
            ),

            CbnMenuItem(
                R.drawable.shopping_cart,
                R.drawable.shopping_cart,
                R.id.navigation_cart
            ),
            CbnMenuItem(
                R.drawable.person,
                R.drawable.person,
                R.id.navigation_profile
            ),
        )

        binding.navView.setMenuItems(menuItems, activeIndex)
        binding.navView.setupWithNavController(navController)
    }


}