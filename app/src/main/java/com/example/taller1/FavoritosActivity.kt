package com.example.taller1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class FavoritosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        var arregloNombres = arrayOfNulls<String>(Data.ARREGLO_FAVORITOS.size)
        arregloNombres = llenarArreglo(arregloNombres, Data.ARREGLO_FAVORITOS)

        val lista = findViewById<ListView>(R.id.favoritosListView)
        val adaptador = ArrayAdapter(baseContext, //Contexto
            android.R.layout.simple_list_item_1, //Forma visual
            arregloNombres.filterNotNull()
        )
        lista.adapter = adaptador
    }

    fun llenarArreglo(arreglo: Array<String?>, favoritos: MutableList<JSONObject>): Array<String?> {
            for (i in 0 until favoritos.size){
                val jsonObject = favoritos[i]
                arreglo[i]=(jsonObject.getString("nombre"))
            }

        return arreglo
    }
}
