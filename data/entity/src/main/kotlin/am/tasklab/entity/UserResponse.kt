package am.tasklab.entity

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("avatar")
    val avatar: String? = null
)
