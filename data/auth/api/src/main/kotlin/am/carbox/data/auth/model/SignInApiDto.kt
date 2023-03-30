package am.carbox.data.auth.model

import com.google.gson.annotations.SerializedName

data class SignInApiDto(
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("regenerateToken")
    val regenerateToken: String? = null
)
