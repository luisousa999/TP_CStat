package ipca.cstat.tp_cstat

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class BackendApiNews {

    companion object {

        suspend fun getLatestNews( ) : String = suspendCoroutine{
            var result = ""
            try {
                //https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.hltv.org%2Frss%2Fnews
                    //https://www.hltv.org/rss/news
                val urlc: HttpURLConnection = URL("https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.hltv.org%2Frss%2Fnews").openConnection() as HttpURLConnection
                urlc.setRequestProperty("User-Agent", "Test")
                urlc.setRequestProperty("Connection", "close")
                urlc.connect()
                val stream = urlc.inputStream
                val isReader = InputStreamReader(stream)
                val brin = BufferedReader(isReader)
                var str: String = ""

                var keepReading = true
                while (keepReading) {
                    var line = brin.readLine()
                    if (line==null){
                        keepReading = false
                    }else{
                        str += line
                    }
                }
                brin.close()
                result = str
            }catch (e:Exception){
                e.printStackTrace()
                result = "Não tem internet!"
            }
            it.resume(result)
        }
    }
}