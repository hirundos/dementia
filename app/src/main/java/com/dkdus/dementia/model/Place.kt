package com.dkdus.dementia.model

import com.dkdus.dementia.model.place_material.Response
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("response")
    @Expose
    var response: Response
)