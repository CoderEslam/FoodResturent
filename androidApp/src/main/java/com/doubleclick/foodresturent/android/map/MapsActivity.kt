package com.doubleclick.foodresturent.android.map

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.doubleclick.foodresturent.android.Adapter.InfoWindowAdapter
import com.doubleclick.foodresturent.android.HomeActivity
import com.doubleclick.foodresturent.android.R
import com.doubleclick.foodresturent.android.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mGoogleMap: GoogleMap
    private var isLocationPermissionOk = false
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var currentLocation: Location
    private var currentMarker: Marker? = null
    private var infoWindowAdapter: InfoWindowAdapter? = null
    private lateinit var binding: ActivityMapsBinding
    private var typeMap: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
//        isLocationPermissioned()
        binding.enable.setOnClickListener {
            Dexter.withContext(this@MapsActivity)
                .withPermissions(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ).withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        getCurrentLocation()
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        permissions: List<PermissionRequest?>?,
                        token: PermissionToken?
                    ) {

                    }
                }).check()
        }

        binding.noIdontit.setOnClickListener {
            startActivity(Intent(this@MapsActivity, HomeActivity::class.java));
        }

        binding.btnMapType.setOnClickListener {
            if (typeMap) {
                mGoogleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                typeMap = false
            } else {
                mGoogleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                typeMap = true
            }
        }
    }

    private fun getCurrentLocation() {
        val fusedLocationProviderClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(this@MapsActivity)
        if (ActivityCompat.checkSelfPermission(
                this@MapsActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this@MapsActivity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            isLocationPermissionOk = false
            return
        }
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                currentLocation = location
                infoWindowAdapter = null
                infoWindowAdapter = InfoWindowAdapter(currentLocation, this@MapsActivity)
                mGoogleMap.setInfoWindowAdapter(infoWindowAdapter)
                moveCameraToLocation(location)
            }
    }

    private fun moveCameraToLocation(location: Location) {
        val cameraUpdate =
            CameraUpdateFactory.newLatLngZoom(LatLng(location.latitude, location.longitude), 17f)
        val markerOptions = MarkerOptions()
            .position(LatLng(location.latitude, location.longitude))
            .title("Current Location")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
            .snippet("")
        if (currentMarker != null) {
            currentMarker!!.remove()
        }
        currentMarker = mGoogleMap.addMarker(markerOptions)!!
        currentMarker!!.tag = 703
        mGoogleMap.animateCamera(cameraUpdate)

        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            startActivity(Intent(this@MapsActivity, HomeActivity::class.java));
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }

/*
    private fun isLocationPermissioned() {
        if (ActivityCompat.checkSelfPermission(
                this@MapsActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this@MapsActivity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            isLocationPermissionOk = false
            return
        } else {
            startActivity(Intent(this@MapsActivity, HomeActivity::class.java));
        }
    }
*/
}