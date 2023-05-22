package com.tasklab.data.auth.model

import com.google.gson.annotations.SerializedName

data class AuthTokenRequest(
    @SerializedName("oldToken")
    val oldToken: String
)
