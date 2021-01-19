package ipca.cstat.tp_cstat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro)


        // Botões Dos Jogadores
        val simpleButton = findViewById<Button>(R.id.button_Simple)
        val xantares = findViewById<Button>(R.id.button_Xantares)
        val zywooButton = findViewById<Button>(R.id.button_Zywoo)

        // O que acontece ao clicar cada botão
        simpleButton.setOnClickListener {
            val intent = Intent(this, News::class.java)
            startActivity(intent)
        }

        xantares.setOnClickListener {
            val intent = Intent(this, Pro::class.java)
            startActivity(intent)
        }

        zywooButton.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }
    }
}