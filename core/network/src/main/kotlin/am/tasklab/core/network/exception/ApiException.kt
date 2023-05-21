package am.tasklab.core.network.exception


sealed class ApiException(override val message: String?) : Throwable() {

    class UnexpectedException : ApiException("UnexpectedException")

    class ResponseException(
        val errorMessage: String = "",
    ) : ApiException(errorMessage)

    class ServerException(
        val errorCode: Int,
        val errorMessage: String = "",
    ) : ApiException(errorMessage)
}
