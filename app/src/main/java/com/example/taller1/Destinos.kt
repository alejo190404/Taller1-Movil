package com.example.taller1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Destinos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_destinos)

        val json = JSONObject(loadJSONFromAsset())
        val destinos = json.getJSONArray("destinos")

        //Arreglo (tamaño estático)
        val arreglo = arrayOfNulls<String>(destinos.length())

        for (i in 0 until destinos.length()){
            val jsonObject = destinos.getJSONObject(i)
            arreglo[i]=(jsonObject.getString("nombre"))
        }

        val lista = findViewById<ListView>(R.id.listView)
        val adaptador = ArrayAdapter(baseContext, //Contexto
            android.R.layout.simple_list_item_1, //Forma visual
            arreglo
        )
        lista.adapter = adaptador
    }

    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val isStream: InputStream = assets.open("destinos.json")
            val size:Int = isStream.available()
            val buffer = ByteArray(size)
            isStream.read(buffer)
            isStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}