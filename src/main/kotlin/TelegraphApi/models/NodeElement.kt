package TelegraphApi.models


/**
 * Created by maratismagilov on 13.10.17.
 */

interface Node

open class NodeElement(
        vararg var children: Any, //Array<Node>,,,,,
        val tag: String? = null,
        open val attrs: Attrs? = null
) : Node


class ImgNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "img", attrs = attrs)

class ParagraphNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "p", attrs =  attrs)

class UlNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "ul", attrs = attrs)

class ANodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "a", attrs = attrs)

class BNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "b", attrs = attrs)


class AsideNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "aside", attrs = attrs)

class BoldNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "b", attrs = attrs)

class BlockquoteNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "blockquote", attrs =  attrs)

class BrNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "br", attrs = attrs)

class CodeNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "code", attrs = attrs)

class ItalicNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "em", attrs = attrs)

class FigcaptionNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "figcaption", attrs = attrs)

class FigureNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "figure", attrs =  attrs)

class H3NodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "h3", attrs =  attrs)

class H4NodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "h4", attrs = attrs)

class HorizontLineNodeElement(
        vararg children: Any,
        attrs: Attrs? = null
) : NodeElement(*children, tag = "hr", attrs = attrs)


//class ImageNodeElement(
//        pathImage: String,
//        description: String
//) : NodeElement(tag = "figure", attrs = null) {
//
//    init {
//        val image = ImgNodeElement(attrs = mapOf(Pair("src", upload(pathImage)?.link)))
//        val figcaption = FigcaptionNodeElement(description)
//        children = arrayOf(figcaption, image)
//    }
//}