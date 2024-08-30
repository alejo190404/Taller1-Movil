package com.example.taller1.Datos

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class Data {
    companion object {
        var ARREGLO_DESTINOS: JSONArray = JSONArray()
        var ARREGLO_FAVORITOS: MutableList<JSONObject> = mutableListOf()

        fun initialize(context: Context) {
            try {
                val json = JSONObject(loadJSONFromAsset(context))
                ARREGLO_DESTINOS = json.getJSONArray("destinos")
            } catch (e: Exception) {
                e.printStackTrace()
                // If there's an error, ARREGLO_DESTINOS will remain an empty JSONArray
            }
        }

        private fun loadJSONFromAsset(context: Context): String {
            return try {
                context.assets.open("destinos.json").use { inputStream ->
                    inputStream.bufferedReader().use { it.readText() }
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
                "{\"destinos\":[]}" // Return a JSON string with an empty array in case of error
            }
        }

        fun getDestinos(): JSONArray = ARREGLO_DESTINOS
    }
}