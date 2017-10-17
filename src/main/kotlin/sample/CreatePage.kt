package sample

import TelegraphApi.Telegraph
import TelegraphApi.TelegraphAccountBuilder
import TelegraphApi.models.NodeElement

/**
 * Created by maratismagilov on 17.10.17.
 */

fun main(args: Array<String>) {

    val account = TelegraphAccountBuilder("Petr", "Petrov", "").build()
    val telegraph = Telegraph(account)
    val page = telegraph.createPage(
            title = "My page",
            content = listOf(NodeElement("p", listOf("paragraph"))), //listOf(ParagraphNodeElement(listOf("sadada")))
            return_content = true
    )
    println(page)
}