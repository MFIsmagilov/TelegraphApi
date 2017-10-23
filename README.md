# Telegraph Kotlin Library

Kotlin wrapper for Telegraph API

# Example

```kotlin
import TelegraphApi.Telegraph
import TelegraphApi.TelegraphAccountBuilder
import TelegraphApi.models.ANodeElement
import TelegraphApi.models.HrefAttrs
import TelegraphApi.models.ParagraphNodeElement

fun main(args: Array<String>) {

    val account = TelegraphAccountBuilder("short_name", "author_name", "").build()
    val telegraph = Telegraph(account)
    val page = telegraph.createPage(
            "My new page",
            listOf(
                    ParagraphNodeElement(
                            ANodeElement("text", attrs = HrefAttrs("https://github.com/"))
                    )
            )
    )
    println(page)
}
```


[More examples](https://github.com/MFIsmagilov/TelegraphApi/tree/master/src/main/kotlin/samples)

# About methods
More information about methods can be read on [TelegraphApi page](http://telegra.ph/api)
