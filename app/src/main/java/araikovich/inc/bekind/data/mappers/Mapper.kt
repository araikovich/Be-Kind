package araikovich.inc.bekind.data.mappers

interface Mapper<SOURCE, RESULT> {

    fun map(source: SOURCE): RESULT

    fun list(source: List<SOURCE>) = source.map { map(it) }
}