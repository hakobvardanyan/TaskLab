package am.carbox.core.network.parser

import am.carbox.core.common.logger.Logger
import am.carbox.core.network.exception.ApiException
import am.carbox.core.network.model.BaseResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class BaseResponseParserImpl @Inject constructor() : BaseResponseParser {

    override fun <T, R : BaseResponse<T>> parse(response: R): T {
        Logger.debug("BaseResponseParserImpl.parseResponse response=$response")
        if (!response.status) {
            response.errorCode?.let {
                throw ApiException.ServerException(it, response.errorMessage.orEmpty())
            } ?: throw ApiException.UnexpectedException()
        }
        response.data?.let {
            return it
        } ?: throw ApiException.ResponseException(RESPONSE_EXCEPTION_MESSAGE)
    }

    companion object {
        private const val RESPONSE_EXCEPTION_MESSAGE = "Data must not be null in response"
    }
}
