package ipca.cstat.tp_cstat

import org.json.JSONObject

class NewsFormat {

    var title : String? = null
    var description : String? = null
    var url : String? = null

    constructor(title : String?, description : String?, url : String?){
        this.title = title
        this.description = description
        this.url = url
    }

    constructor(){
    }

    companion object {
        fun fromJson(jsonObject : JSONObject): NewsFormat{
            var news = NewsFormat()
            news.title              = jsonObject.getString("title")
            news.description        = jsonObject.getString("description")
            news.url                = jsonObject.getString("link")
            return news
        }
    }
}