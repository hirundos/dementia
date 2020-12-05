package com.dkdus.dementia.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dkdus.dementia.model.Place
import com.dkdus.dementia.util.PlaceUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    fun callPlace() {
        val placeUtil = PlaceUtil()

        placeUtil.getApi().getPlace("10", "json")
                .enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        Log.d("Success",response.body().toString())
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Log.d("Fail",t.message.toString())
                    }

                })
    }
}

