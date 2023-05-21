package am.tasklab.core.network.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status")
    val status: Boolean = false,
    @SerializedName("timestamp")
    val timestamp: Long? = null,
    @SerializedName("errorCode")
    val errorCode: Int? = null,
    @SerializedName("errorMessage")
    val errorMessage: String? = null,
    @SerializedName("data")
    val data: T? = null
)