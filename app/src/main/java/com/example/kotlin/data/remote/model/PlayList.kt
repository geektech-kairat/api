package com.example.kotlin.data.remote.model

import com.google.gson.annotations.SerializedName

data class PlayList(
    @SerializedName("etag")
    val eTag: String? = null,

    @SerializedName("kind")
    val king: String? = null,

    @SerializedName("nextPageToken")
    val nextPageToken: String? = null,

    @SerializedName("prevPageToken")
    val prevPageToken: String? = null
)
