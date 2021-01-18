package ipca.cstat.tp_cstat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class NewsDetailActivity : AppCompatActivity() {

    var urlString : String? = null
    var newsTitle : String? = null

    var webView : WebView? = null

    companion object {
        const val NEWS_URL = "news_url"
        const val NEWS_TITLE = "news_title"
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        urlString = intent.getStringExtra(NEWS_URL)
        newsTitle = intent.getStringExtra(NEWS_TITLE)

        title = newsTitle

        webView = findViewById(R.id.webViewNews)

        urlString?.let{
            webView?.loadUrl(it)
        }

        val webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
                url?.let { view?.loadUrl(it) }
                return true
            }
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            webView?.webViewClient = webViewClient
        }
    }
}