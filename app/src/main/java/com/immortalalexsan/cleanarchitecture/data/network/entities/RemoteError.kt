package com.immortalalexsan.cleanarchitecture.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteError(
    @Expose @SerializedName("code") val code: Int,
    @Expose @SerializedName("message") val message: String
)
