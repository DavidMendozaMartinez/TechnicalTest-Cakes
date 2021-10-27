package com.davidmendozamartinez.technicaltest.cakes.data.remote.model

import com.google.gson.annotations.SerializedName

data class CakeRemote(
    @SerializedName("title") val title: String,
    @SerializedName("desc") val description: String,
    @SerializedName("image") val image: String
)
