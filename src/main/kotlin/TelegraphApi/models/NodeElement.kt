package TelegraphApi.models

import TelegraphApi.uploaders.upload


/**
 * Created by maratismagilov on 13.10.17.
 */

interface Node

open class NodeElement(
        val tag: String? = null,
        open val children: Any? = null, //List<Node>,,,
        open val attrs: Any? = null
): Node


class ImageNodeElement(
        pathImage: String,
        description: String
): NodeElement("figure"){
    override val children: Any?
    init {
        val image = ImgNodeElement(attrs = mapOf(Pair("src", upload(pathImage)?.link)))
        val figcaption = FigcaptionNodeElement(listOf(description))
        children = listOf(figcaption, image)
    }
}

class ImgNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("img", children, attrs)

class ParagraphNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("p", children, attrs)

class AsideNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("aside", children, attrs)

class BoldNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("b", children, attrs)

class BlockquoteNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("blockquote", children, attrs)

class BrNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("br", children, attrs)

class CodeNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("code", children, attrs)

class ItalicNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("em", children, attrs)

class FigcaptionNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("figcaption", children, attrs)

class FigureNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("figure", children, attrs)

class H3NodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("h3", children, attrs)

class H4NodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("h4", children, attrs)

class HorizontLineNodeElement(
        children: Any? = null,
        attrs: Any? = null
):NodeElement("hr", children, attrs)