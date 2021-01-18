package ipca.cstat.tp_cstat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONArray
import org.json.JSONObject

class News : AppCompatActivity() {

    //Data rec
    var news: MutableList<NewsFormat> = ArrayList()
    var newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val listViewNews = findViewById<ListView>(R.id.listViewNews)
        listViewNews.adapter = newsAdapter

        GlobalScope.async {
            var result = BackendApiNews.getLatestNews()
            if (result=="Não tem internet!"){
                runOnUiThread {
                    Toast.makeText(this@News, "Não tem internet!", Toast.LENGTH_LONG).show()
                }
            }else {
                val jsonObject = JSONObject(result)
                if (jsonObject.get("status").equals("ok")){
                    var jsonArray : JSONArray = jsonObject.getJSONArray("items")
                    for (index in 0 until jsonArray.length()){
                        val jsonNews = jsonArray.getJSONObject(index)
                        val artigo = NewsFormat.fromJson(jsonNews)
                        news.add(artigo)
                    }
                    runOnUiThread {
                        newsAdapter.notifyDataSetChanged()
                    }

                }
            }
        }
    }

    inner class NewsAdapter : BaseAdapter() {
        override fun getView(position: Int, view: View?, viewGroup : ViewGroup?): View {
            val rowView = layoutInflater.inflate(R.layout.row_news, viewGroup, false)

            val textViewTitle = rowView.findViewById<TextView>(R.id.textViewTitle)
            val textViewDescription = rowView.findViewById<TextView>(R.id.textViewDescription)


            textViewTitle.text       = news[position].title
            textViewDescription.text = news[position].description

            rowView.isClickable = true
            rowView.setOnClickListener {
                val intent = Intent (this@News, NewsDetailActivity::class.java)
                intent.putExtra(NewsDetailActivity.NEWS_URL   , news[position].url)
                intent.putExtra(NewsDetailActivity.NEWS_TITLE , news[position].title)
                startActivity(intent)
            }

            return rowView
        }
        override fun getItem(position: Int): Any {
            return news[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return  news.size
        }

    }
}