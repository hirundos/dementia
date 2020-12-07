package com.dkdus.dementia.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dkdus.dementia.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.w3c.dom.Node


class HomeFragment : Fragment(), OnMapReadyCallback {

    lateinit var viewModel: HomeViewModel
    private lateinit var mMap: GoogleMap
    var data: MutableList<Node> = arrayListOf()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
             placeCall()
    }

    private fun placeCall(){
        viewModel.callPlace().observe(viewLifecycleOwner, Observer {
            Log.d("사이즈가 얼마인가!!여기다",it.size.toString())
            val it2 = it.iterator()
            while(it2.hasNext()){
                Log.d("D~~~","count")
                var lat = it2.next().attributes.getNamedItem("latitude").textContent.toDouble()
                var lot = it2.next().attributes.getNamedItem("longitude").textContent.toDouble()
                mMap.addMarker(
                    MarkerOptions()
                        .position(LatLng(lat,lot))
                )
            }})
        }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        val marker = LatLng(35.241615, 128.695587)
        mMap.addMarker(MarkerOptions().position(marker).title("Marker LAB"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,7f))



    }


}