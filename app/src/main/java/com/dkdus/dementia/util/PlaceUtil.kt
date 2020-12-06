package com.dkdus.dementia.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class PlaceUtil {
    var placeAPI: PlaceAPI
    init {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://api.data.go.kr/openapi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        placeAPI  = retrofit.create(PlaceAPI::class.java)
    }
    public fun getApi() : PlaceAPI {
        return placeAPI
    }
}