package TelegraphApi.models

/**
 * Created by maratismagilov on 13.10.17.
 */


data class Account constructor(
        var author_name: String,
        val access_token: String,
        val author_url: String,
        var short_name: String,
        val auth_url: String
)

data class Author constructor(
        val short_name: String,
        val author_name: String,
        val author_url: String?
)

data class AccountInfo(
        val short_name: String?,
        val author_name: String?,
        val author_url: String?,
        val auth_url: String?,
        val page_count: String?
)


internal class RequestRevokeAccessToken(
        val access_token: String
)

internal class RequestAccountInfo(
        val access_token: String,
        val fields: List<String>
)

internal class UpdateAccount{
    companion object{
        fun updateAccount(account: Account, newData: Author): Account {
            return Account(newData.author_name, account.access_token, newData.author_url ?: "", newData.short_name, account.auth_url)
        }
    }
}
