package com.dkdus.dementia.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dkdus.dementia.model.Place
import com.dkdus.dementia.util.PlaceUtil
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    fun callPlace(){
        val placeUtil = PlaceUtil()

        placeUtil.getApi().getPlace("10", "json")
                .enqueue(object : Callback<Place> {
                    override fun onResponse(call: Call<Place>, response: Response<Place>) {
                        Log.d("Success",response.message())
                    }
                    override fun onFailure(call: Call<Place>, t: Throwable) {
                        Log.d("Fail",t.message.toString())
                    }

                })

    }
}

