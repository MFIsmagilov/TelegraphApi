package samples

import TelegraphApi.Telegraph
import TelegraphApi.models.*
import main.acc

/**
 * Created by maratismagilov on 19.10.17.
 */

fun main(args: Array<String>) {
    //acc - you account
    val telegraph = Telegraph(acc)
    val pageEdit = telegraph.getPage("My new page", true)
    if (pageEdit != null) {
        val page = telegraph.editPage(
                page = pageEdit,
                title = "New Title",
                content = listOf(
                        BlockquoteNodeElement("Text"),
                        BrNodeElement(),
                        ParagraphNodeElement("Text Paragraph"),
                        HorizontLineNodeElement()
                )
        )
        println(page)
    }
}