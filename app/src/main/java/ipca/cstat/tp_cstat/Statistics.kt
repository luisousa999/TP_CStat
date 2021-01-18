package ipca.cstat.tp_cstat

import org.json.JSONObject

class Statistics {
    var steamname           : String ?= null //"platformUserHandle"
    var steampicture        : String ?= null //"avatarUrl": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/95/950f9f3147d4c8530a5072825d01c34ee3f1afa1_full.jpg"
    var kills               : Int ?= null
    var deaths              : Int ?= null
    var headshots           : Int ?= null
    var kda                 : Int? = null
    var wins                : Int ?= null
    var losses              : Int ?= null
    var wlpercentage        : Int ?= null

    constructor(){

    }

    constructor(
        steamname: String?,
        steampicture: String?,
        kills: Int?,
        deaths: Int?,
        headshots: Int?,
        kda: Int?,
        wins: Int?,
        losses: Int?,
        wlpercentage: Int?
    ){
        this.steamname = steamname
        this.steampicture = steampicture
        this.kills = kills
        this.deaths = deaths
        this.headshots = headshots
        this.kda = kda
        this.wins = wins
        this.losses = losses
        this.wlpercentage = wlpercentage
    }

    companion object {
        fun fromJson(jsonObject: JSONObject):Statistics {
            var statistics = Statistics()

            statistics.steamname = jsonObject.getString("platformUserHandle")
            statistics.steampicture = jsonObject.getString("avatarURL")
            statistics.kills = jsonObject.getInt("kills.value")
            statistics.deaths = jsonObject.getInt("deaths.value")
            statistics.headshots = jsonObject.getInt("headshots.value")
            statistics.kda = jsonObject.getInt("kd.value")
            statistics.wins = jsonObject.getInt("wins.value")
            statistics.losses = jsonObject.getInt("losses.value")
            statistics.wlpercentage = jsonObject.getInt("wlpercentage.value")

            return statistics
        }
    }
}