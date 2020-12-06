package com.dkdus.dementia.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dkdus.dementia.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    val CITY_HALL = LatLng(37.5662952, 126.97794509999994)
    var googleMap : GoogleMap? = null
    lateinit var viewModel: HomeViewModel
    val contextHome by lazy { this }
    val PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION)

    val REQUEST_PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

  //      mapView.onCreate(savedInstanceState)

        if(checkPermissions()){
//            initMap()
        }else{
            ActivityCompat.requestPermissions(requireActivity(), PERMISSIONS, REQUEST_PERMISSION_CODE)
        }
   //     myLocationButton.setOnClickListener {  }

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
   //     placeCall()
    }

    private fun placeCall(){
        viewModel.callPlace()
    }

    private fun checkPermissions() : Boolean {
        for(permission in PERMISSIONS){
            if(ActivityCompat.checkSelfPermission(requireActivity(), permission) != PackageManager.PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        initMap()
    }

    @SuppressLint("MissingPermission")
    private fun initMap() {
        mapView.getMapAsync {
            googleMap = it
            it.uiSettings.isMyLocationButtonEnabled = false

            when{
                checkPermissions() -> {
                    if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION )
                        != PackageManager.PERMISSION_GRANTED) {
                        return@getMapAsync
                    }
                    it.isMyLocationEnabled = true
                    it.moveCamera(CameraUpdateFactory.newLatLngZoom(CITY_HALL, 17f))
                }
                else->{
                    it.moveCamera(CameraUpdateFactory.newLatLngZoom(CITY_HALL, 17f))
                }
            }

        }
    }

    /*
    @SuppressLint("MissingPermission")
    fun getMyLocation() : LatLng{
        val locationProvider: String = LocationManager.GPS_PROVIDER


        val locationManager =  getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val lastKnownLocation: Location? = locationManager.getLastKnownLocation(locationProvider)
        return LatLng(lastKnownLocation?.latitude!!, lastKnownLocation.longitude)
    }



    private fun onMyLocationButtonClick() {
        when {
            checkPermissions() -> googleMap?.moveCamera(
                CameraUpdateFactory.newLatLngZoom(getMyLocation(), 17f)
            )
            else -> Toast.makeText(requireContext(), "위치사용권한 설정에 동의해주세요", Toast.LENGTH_LONG).show()
        }
    }

     */


}