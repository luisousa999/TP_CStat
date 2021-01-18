package ipca.cstat.tp_cstat

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.suspendCoroutine
import kotlin.coroutines.resume

class BackendApi {
    companion object {
        suspend fun procuraSteam() : String = suspendCoroutine {

            var result = ""

            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://public-api.tracker.gg/v2/csgo/standard/profile/steam/luspt")
                .get()
                .addHeader("TRN-Api-Key", "d6f2be38-9483-4c96-ba74-892492f05198")
                .addHeader("Accept", "application/json")
                .addHeader("Accept-Encoding", "gzip")
                .build()

            val response = client.newCall(request).execute()
            Log.d("MainActivity", response.message)
            Log.d("MainActivity", response.body?.string()?:"")

            var  stream : String? = response.body?.string().toString()
            Log.e("teste",stream?:"")
            if (stream != null) {
                result = stream
            }
            else {
                result = "Sem Internet!"
            }

            it.resume(result)
        }
    }



}