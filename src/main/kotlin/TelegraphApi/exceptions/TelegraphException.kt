package TelegraphApi.exceptions

/**
 * Created by maratismagilov on 17.10.17.
 */

open class TelegraphException(override val message: String?): Exception()

class EmptyTagException(message: String?): TelegraphException(message)