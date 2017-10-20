package samples

import TelegraphApi.Telegraph
import TelegraphApi.models.*
import main.acc

/**
 * Created by maratismagilov on 20.10.17.
 */

fun main(args: Array<String>) {

    //you image
    val pathImage = "src/main/kotlin/main/1.jpg"

    //acc - you account
    val telegraph = Telegraph(acc)

    val page = telegraph.createPage(
            title = "Easy load image",
            content = listOf(
                    ImageNodeElement(
                            pathImage = pathImage,
                            description = "Image"
                    )
            )
    )
    println(page)
}