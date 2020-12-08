package com.dkdus.dementia.ui.home

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dkdus.dementia.R
import com.dkdus.dementia.model.Item
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory


class HomeFragment : Fragment(), OnMapReadyCallback {

    lateinit var viewModel: HomeViewModel
    private lateinit var mMap: GoogleMap
    var data: MutableList<Item> = arrayListOf()


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

    private fun placeCall() {
        viewModel.callPlace().observe(viewLifecycleOwner, Observer {
            var xpath: XPath = XPathFactory.newInstance().newXPath()

            var lat = xpath.evaluate(
                "//body/items/item/latitude",
                it, XPathConstants.NODESET
            ) as NodeList?
            var lot = xpath.evaluate(
                "//body/items/item/longitude",
                it, XPathConstants.NODESET
            ) as NodeList?
            var cntername = xpath.evaluate(
                "//body/items/item/cnterNm",
                it, XPathConstants.NODESET
            ) as NodeList?
            var lnmadr = xpath.evaluate(
                "//body/items/item/lnmadr",
                it, XPathConstants.NODESET
            ) as NodeList?
            var imbcltyIntrcn = xpath.evaluate(
                "//body/items/item/imbcltyIntrcn",
                it, XPathConstants.NODESET
            ) as NodeList?

            for(i in 0..lat?.length!!-1){

            mMap.addMarker(
                MarkerOptions().position(LatLng(lat.item(i).textContent.toDouble(), lot?.item(i)?.textContent!!.toDouble()))
                    .title(cntername!!.item(i).textContent)
            )}

        })
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        val marker = LatLng(35.241615, 128.695587)
        mMap.addMarker(MarkerOptions().position(marker).title("Marker LAB"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,7f))
    }

}