package ipca.cstat.tp_cstat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botões do Menu Principal
        val searchButton = findViewById<Button>(R.id.button_Search)
        val newsButton = findViewById<Button>(R.id.button_News)
        val proButton = findViewById<Button>(R.id.button_Pro)

        // O que acontece ao clicar cada botão
        newsButton.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        proButton.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        searchButton.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }
    }
}

