package com.tasklab.data.auth.model

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("expire")
    val tokenExpireTime: String? = null,
    @SerializedName("regenerateExpire")
    val regenerateTokenExpireTime: String? = null
)
