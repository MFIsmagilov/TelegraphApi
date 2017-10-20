package TelegraphApi

import TelegraphApi.HttpClientWrapper.HttpClientWrapper
import TelegraphApi.models.*
import kotlin.concurrent.thread

interface TelegraphCallback<T>{
    fun onSuccess(obj: T)
    fun onFailure(exception: Exception)
}

class TelegraphAccountBuilder(
        val short_name: String,
        val author_name: String,
        val author_url: String
){
    private val requests: HttpClientWrapper = HttpClientWrapper()
    private val createPageUrl = "https://api.telegra.ph/createAccount"

    fun build(): Account {
        val author = Author(short_name, author_name, author_url)
        return requests.post(url = createPageUrl, obj = author, clazz = Account::class.java)
    }

    fun buildAsync(callback: TelegraphCallback<Account>){
        thread(start = true) {
            try {
                val acc = build()
                callback.onSuccess(acc)
            }catch (ex: kotlin.Exception) {
                callback.onFailure(ex)
            }
        }
    }
}

class Telegraph(val account: Account) {
    val url = "https://api.telegra.ph/"
    private val requests: HttpClientWrapper = HttpClientWrapper()

    private val createPageUrl = url + "createPage"
    private val editAccountInfoUrl = url + "editAccountInfo"
    private val editPageUrl = url + "editPage"
    private val getAccountInfoUrl = url + "getAccountInfo"
    private val getPageUrl = url + "getPage"
    private val getPageListUrl = url + "getPageList"
    private val getViewsUrl = url + "getViews"
    private val revokeAccessTokenUrl = url + "revokeAccessToken"

    fun createPage(title: String, content: List<Node>, return_content: Boolean = false): Page? {

        val cp = CreatorPage(
                account.access_token,
                title,
                account.author_name,
                account.auth_url,
                content,
                return_content
        )
        val page = requests.post(url = createPageUrl, obj = cp, clazz = Page::class.java)
        return page
    }

    fun editAccountInfo(newAccountData: Author): Account? {
        val updatedAccount = UpdateAccount.updateAccount(account, newAccountData)
        val result = requests.post(url = editAccountInfoUrl, obj = updatedAccount, clazz = Author::class.java)
        if(result != null) {
            account.short_name = result.short_name
            account.author_name = result.author_name
            account.author_name = result.author_name
            return account
        }
        return result
    }

    fun editPage(page: Page, title: String, content: List<NodeElement>, author_name: String? = null, author_url: String? = null, return_content: Boolean = false): Page? {
        val page = PagePatch(
                account.access_token,
                page.path,
                title,
                content,
                author_name,
                author_url
                )

        val result = requests.post(url = editPageUrl, obj = page, clazz = Page::class.java)
        return result
    }

    fun getAccountInfo(fields: List<String> = listOf("short_name", "author_name", "author_url")): AccountInfo? {
        val requestAccountInfo = RequestAccountInfo(account.access_token, fields)
        return requests.post(url = getAccountInfoUrl, obj = requestAccountInfo, clazz = AccountInfo::class.java)
    }

    fun getPage(path: String, return_content: Boolean = false): Page? {
        class PagePath(val path: String, val return_content: Boolean)
        val result = requests.post(url = getPageUrl, obj = PagePath(path, return_content), clazz = Page::class.java)
        return result
    }

    fun getPageList(offset: Int = 0, limit: Int = 50): PageList? {
        val requestPageList = RequestPageList(account.access_token, offset, limit)
        return requests.post(url = getPageListUrl, obj = requestPageList, clazz = PageList::class.java)
    }

    fun getViews(path: String, year: Int, month: Int? = null, day: Int? = null, hour: Int? = null): PageViews? {
        val requestPageViews = RequestPageViews(path, year, month, day, hour)
        return requests.post(url = getViewsUrl, obj = requestPageViews, clazz = PageViews::class.java)
    }

    fun revokeAccessToken(): Account? {
        val requestRevokeAccessToken = RequestRevokeAccessToken(account.access_token)
        return requests.post(url = revokeAccessTokenUrl, obj = requestRevokeAccessToken, clazz = Account::class.java)
    }
}