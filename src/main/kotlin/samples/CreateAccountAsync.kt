package samples

import TelegraphApi.TelegraphAccountBuilder
import TelegraphApi.TelegraphCallback
import TelegraphApi.exceptions.TelegraphException
import TelegraphApi.models.Account

/**
 * Created by maratismagilov on 20.10.17.
 */

fun main(args: Array<String>) {
    try {
        val account = TelegraphAccountBuilder("short_name", "author_name", "").buildAsync(object : TelegraphCallback<Account> {
            override fun onSuccess(obj: Account) {
                println(obj)
            }

            override fun onFailure(exception: Exception) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    } catch (ex: TelegraphException) {
        ex.printStackTrace()
    }
    println("sf")
}