package am.tasklab.core.network.parser

import am.tasklab.core.network.model.BaseResponse

interface BaseResponseParser {
    fun <T, R : BaseResponse<T>> parse(response: R): T
}
