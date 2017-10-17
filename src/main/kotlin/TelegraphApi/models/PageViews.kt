package TelegraphApi.models

/**
 * Created by maratismagilov on 13.10.17.
 */


data class PageViews(
        val views: Int
)

internal class RequestPageViews(
        val path: String,
        val year: Int?,
        val month: Int?,
        val day: Int?,
        val hour: Int?
)