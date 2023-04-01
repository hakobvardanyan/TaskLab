package am.carbox.core.network.parser

import am.carbox.core.network.model.BaseResponse

interface BaseResponseParser {
    fun <T, R : BaseResponse<T>> parse(response: R): T
}
