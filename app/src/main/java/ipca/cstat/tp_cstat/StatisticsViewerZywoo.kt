package ipca.cstat.tp_cstat

import android.os.Bundle
import android.view.View
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONArray
import org.json.JSONObject

class StatisticsViewerZywoo : AppCompatActivity() {

    var statistics : MutableList<Statistics> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statviewer)

        statistics.add(Statistics("Zywoo", "", 400 ,100 ,99 , 40, 100, 50, 2, 3 ))

        val textName = findViewById<TextView>(R.id.player_name)
        val textKills = findViewById<TextView>(R.id.player_kills)
        val textdeaths = findViewById<TextView>(R.id.player_deaths)
        //val textheadshots = findViewById<TextView>(R.id.player_kills)
        val textkda = findViewById<TextView>(R.id.player_kda)
        val textwins = findViewById<TextView>(R.id.player_wins)
        val textlosses = findViewById<TextView>(R.id.player_losses)
        val textwl = findViewById<TextView>(R.id.player_wl)

        textName.text = statistics[3].steamname
        textKills.text = statistics[3].kills.toString()
        textdeaths.text = statistics[3].deaths.toString()
        //textheadshots = statistics[numero].headshots
        textkda.text = statistics[3].kda.toString()
        textwins.text = statistics[3].wins.toString()
        textlosses.text = statistics[3].losses.toString()
        textwl.text = statistics[3].wlpercentage.toString()
    }

}
