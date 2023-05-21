package com.tasklab.data.auth.model

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("expire")
    val tokenExpireTime: String? = null,
    @SerializedName("regenerateExpire")
    val regenerateTokenExpireTime: String? = null
)