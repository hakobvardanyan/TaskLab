package am.tasklab.entity

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("id")
    val id: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("age")
    val age: Int
)
