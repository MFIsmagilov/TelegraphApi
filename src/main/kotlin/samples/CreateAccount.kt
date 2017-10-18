package samples

import TelegraphApi.Telegraph
import TelegraphApi.TelegraphAccountBuilder
import TelegraphApi.exceptions.TelegraphException

/**
 * Created by maratismagilov on 17.10.17.
 */


fun main(args: Array<String>) {
    try {
        val account = TelegraphAccountBuilder("Petr", "Petrov", "").build()
        val telegraph = Telegraph(account)
        println(account)
    } catch (ex: TelegraphException) {
        ex.printStackTrace()
    }
}