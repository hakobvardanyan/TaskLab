package am.tasklab.core.common.mapper

fun interface Mapper<SOURCE, RESULT> {

    fun map(from: SOURCE): RESULT

    fun map(from: List<SOURCE>): List<RESULT> = from.map(::map)
}