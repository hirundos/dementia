package com.dkdus.dementia.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dkdus.dementia.util.PlaceUtil
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

class HomeViewModel : ViewModel() {
    fun callPlace() : MutableLiveData<MutableList<Node>>{
        val placeUtil = PlaceUtil()
        val data: MutableLiveData<MutableList<Node>> = MutableLiveData()
        placeUtil.getApi().getPlace("10","xml")
            .enqueue(object : Callback<String>{
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("Fail~~~",t.message.toString())
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
             //       Log.d("Success",response.body().toString())

                    var factory : DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
                    var builder : DocumentBuilder = factory.newDocumentBuilder()
                    var ins : InputSource = InputSource(StringReader(response.body()))
                    var document : Document =  builder.parse(ins)
                    var xpath : XPath = XPathFactory.newInstance().newXPath()
                    var cols = xpath.evaluate("//body/items/item",
                        document,XPathConstants.NODESET) as NodeList?

                    for(i in 0..cols!!.length-1){
                        data.value?.add(cols.item(i))
                    }
                }
            })
        return data
    }
}

