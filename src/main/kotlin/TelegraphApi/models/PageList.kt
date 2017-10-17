package TelegraphApi.models


/**
 * Created by maratismagilov on 13.10.17.
 */


data class PageList(
        val total_count: Int,
        val pages: List<Page>
)

internal class RequestPageList(
        val access_token: String,
        val offset: Int,
        val limit: Int
)