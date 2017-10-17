package TelegraphApi.uploaders

import TelegraphApi.HttpClientWrapper.HttpClientWrapper
import TelegraphApi.models.LinkFile
import TelegraphApi.models.RequestUploadFile
import TelegraphApi.models.TelegraphFile

/**
 * Created by maratismagilov on 17.10.17.
 */


val uploadUrl = "http://telegra.ph/upload"
val telegraphUrl = "http://telegra.ph"

fun upload(pathFile: String): LinkFile? {
    val result = HttpClientWrapper().post(
            url = uploadUrl,
            clazz = RequestUploadFile::class.java,
            obj = null,
            file = TelegraphFile(pathFile)
    )
    if(result != null) {
        return LinkFile(telegraphUrl + result.src)
    }
    return null
}

