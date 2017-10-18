package samples

import TelegraphApi.Telegraph
import TelegraphApi.TelegraphAccountBuilder
import TelegraphApi.models.ANodeElement
import TelegraphApi.models.HrefAttrs
import TelegraphApi.models.ParagraphNodeElement

/**
 * Created by maratismagilov on 17.10.17.
 */

fun main(args: Array<String>) {

    val account = TelegraphAccountBuilder("Petr", "Petrov", "").build()
    val telegraph = Telegraph(account)
    val page = telegraph.createPage(
            "My new page",
            listOf(
                    ParagraphNodeElement(
                            ANodeElement("text", attrs = HrefAttrs("https://ya.ru"))
                    )
            )
    )
    println(page)
}