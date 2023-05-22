package com.tasklab.data.auth.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("userId")
    val id: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("age")
    val age: Int? = null
)