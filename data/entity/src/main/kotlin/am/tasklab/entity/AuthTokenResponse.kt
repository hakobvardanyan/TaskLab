package am.tasklab.entity

import com.google.gson.annotations.SerializedName

data class AuthTokenResponse(
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("userId")
    val userId: String? = null
)
