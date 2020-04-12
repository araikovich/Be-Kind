package araikovich.inc.bekind.data.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

private var gson: Gson? = null

object GsonProvider {

    fun gson(): Gson {
        if (gson == null) {
            gson = GsonBuilder().create()
        }
        return gson!!
    }
}
