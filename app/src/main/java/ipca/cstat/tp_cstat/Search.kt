package ipca.cstat.tp_cstat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText


class Search : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val steamID = findViewById<EditText>(R.id.editSteamID)


        // Erro relativo ao procurar pelos stats do jogador com a procura
    }
}