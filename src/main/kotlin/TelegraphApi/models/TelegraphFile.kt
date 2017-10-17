package TelegraphApi.models

import org.apache.commons.io.FilenameUtils
import org.apache.http.entity.ContentType
import java.io.File

/**
 * Created by maratismagilov on 17.10.17.
 */

class LinkFile(val link: String)

internal class RequestUploadFile(val src: String)


class TelegraphFile(val file: File){

    val name: String = "file"
    val nameTypeFile: String
    val contentType: ContentType


    constructor(path: String) : this(File(path))

    init {
        nameTypeFile = FilenameUtils.getExtension(file.absolutePath)
        contentType = ContentType.create(TypeTelegraphFile.from(nameTypeFile).type)
    }


    private enum class TypeTelegraphFile(val type: String){
        PNG("image/png"),
        GIF("image/gif"),
        JPEG("image/jpeg"),
        JPG("image/jpg"),

        MP4("video/mp4");

        companion object{
            fun from(type: String) = TypeTelegraphFile.values().first { it.type.toLowerCase().contains(type.toLowerCase()) }
        }
    }
}

