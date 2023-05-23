package am.tasklab.entity

import com.google.gson.annotations.SerializedName

data class AuthTokenRequest(
    @SerializedName("oldToken")
    val oldToken: String
)
