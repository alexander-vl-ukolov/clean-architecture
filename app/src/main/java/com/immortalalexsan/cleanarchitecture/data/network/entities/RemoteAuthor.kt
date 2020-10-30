package com.immortalalexsan.cleanarchitecture.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteAuthor(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("surname") val surname: String
)
