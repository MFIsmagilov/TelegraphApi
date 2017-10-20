package TelegraphApi.models

/**
 * Created by maratismagilov on 13.10.17.
 */


data class Page(
        val path: String,
        val url: String,
        val title: String,
        val description: String,
        val author_name: String,
        val content: List<Node>,
        val views: Int,
        val can_edit: Boolean,
        val author_url: String? = null,
        val image_url: String? = null
)


internal data class CreatorPage(
        val access_token: String,
        val title: String,
        val author_name: String,
        val auth_url: String,
        val content: List<Any>,
        val return_content: Boolean = true
)

internal data class PagePatch(
        val access_token: String,
        val path: String,
        val title: String,
        val content: List<NodeElement>,

        val author_name: String? = null,
        val author_url: String? = null
)