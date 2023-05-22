package com.tasklab.data.auth.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("user")
    val user: UserResponse? = null,
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("regenerateToken")
    val regenerateToken: String? = null
)
