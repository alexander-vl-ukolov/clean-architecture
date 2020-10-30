package com.immortalalexsan.cleanarchitecture.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteBook(
    @Expose @SerializedName("id") val id: Long,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("author") val author: RemoteAuthor
)
