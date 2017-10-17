package TelegraphApi.HttpClientWrapper

import TelegraphApi.exceptions.TelegraphException
import TelegraphApi.models.TelegraphFile
import com.google.gson.Gson
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by maratismagilov on 17.10.17.
 */

class HttpClientWrapper{

    private val headers = mapOf(Pair("Content-Type", "application/json"))

    //keys
    private val ok = "ok"
    private val result = "result"
    private val src = "src"
    private val error = "error"

    fun <T> post(url: String, clazz: Class<out T>, obj: Any? = null,  file: TelegraphFile? = null):T {

        if(obj == null && file == null)
            throw Exception("One of the parameters is needed: obj or file")

        if(file == null) {
            val resultPostRequest = post(url = url, headers = headers, json = JSONObject(obj))
            if (resultPostRequest.getBoolean(ok)) {
                return Gson().fromJson(resultPostRequest.getJSONObject(result).toString(), clazz)
            }else{
                throw TelegraphException(resultPostRequest.getString(error))
            }
        }else{
            val resultPostRequest = post(url, headers, file)
            return Gson().fromJson(resultPostRequest.toString(), clazz)
        }
    }

    //todo: need to be redone
    private fun post(url: String, headers: Map<String, String>, json: JSONObject): JSONObject {
        val client = HttpClients.createDefault()
        val httpPost = HttpPost(url)
        headers.map {
            httpPost.addHeader(it.key, it.value)
        }
        val jsonEntity = StringEntity(json.toString(), ContentType.APPLICATION_JSON)
        httpPost.entity = jsonEntity
        val response = client.execute(httpPost)
        val jsonObject = JSONObject(EntityUtils.toString(response.entity))
        client.close()
        return jsonObject
    }

    private fun post(url: String, headers: Map<String, String>, file: TelegraphFile): JSONObject {
        val client = HttpClients.createDefault()
        val httpPost = HttpPost(url)
        headers.map {
            httpPost.addHeader(it.key, it.value)
        }
        val builder = MultipartEntityBuilder.create()
        builder.addBinaryBody(file.name, file.file, file.contentType, file.file.absolutePath)
        val multipart = builder.build()
        httpPost.entity = multipart
        val response = client.execute(httpPost)

        //todo: ???
        val entityString = EntityUtils.toString(response.entity)
        try {
            val jsonObject = JSONArray(entityString).getJSONObject(0)
            client.close()
            return jsonObject
        }catch (ex: Exception){
            throw TelegraphException(JSONObject(entityString)[error].toString())
        }
    }
}

