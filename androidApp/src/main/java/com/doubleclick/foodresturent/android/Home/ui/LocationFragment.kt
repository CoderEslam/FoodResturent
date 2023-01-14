package com.doubleclick.foodresturent.android.Home.ui

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.doubleclick.foodresturent.android.Adapter.AddressAdapter
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.no_internet_connection.*
import java.io.IOException

class LocationFragment : Fragment(), OnMapReadyCallback {

    lateinit var binding: FragmentLocationBinding
    private lateinit var mMap: GoogleMap
    private val TAG = "LocationFragment"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPreviousSearch.apply {
            adapter = AddressAdapter()
        }

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                var location = query.toString();
                var addressList: List<Address>? = null
                try {
                    if (location.isNotEmpty()) {
                        var geocoder = Geocoder(requireActivity());
                        try {
                            addressList = geocoder.getFromLocationName(location, 1)
                        } catch (e: IOException) {
                            Log.e(TAG, "beforeTextChanged: ${e.message}")
                        }
                        var address = addressList!![0];
                        var latlang = LatLng(address.latitude, address.longitude)
                        mMap.addMarker(MarkerOptions().position(latlang))
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlang, 10f))
                    }
                } catch (e: IndexOutOfBoundsException) {
                    Log.e(TAG, "beforeTextChanged: ${e.message}")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener {
            // When clicked on map
            // Initialize marker options
            val markerOptions = MarkerOptions()
            // Set position of marker
            markerOptions.position(it)
            // Set title of marker
            markerOptions.title("${it.latitude} : ${it.longitude}")
            // Remove all marker
            mMap.clear()
            // Animating to zoom the marker
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(it, 10f))
            // Add marker on map
            mMap.addMarker(markerOptions)
        }
    }
}