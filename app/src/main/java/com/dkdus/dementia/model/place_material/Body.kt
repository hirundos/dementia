package com.dkdus.dementia.model.place_material



data class Body (
    var items : MutableList<Items>,
    var totalCount : String,
    var numOfRows : String,
    var pageNo : String
        )