package com.example.taller1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class DetalleDestinosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_destinos)

        val nomIntent:String = intent.getStringExtra("destino")!!

//        Data.initialize(baseContext)
        Log.i("JSONObject", Data.ARREGLO_DESTINOS.toString())
        val destino:JSONObject = findDestinoByName(nomIntent);

        var nomDestino:TextView = findViewById(R.id.nombreDestino)
        var pais:TextView = findViewById(R.id.nombrePais)
        var categoria:TextView = findViewById(R.id.nombreCategoria)
        var plan:TextView = findViewById(R.id.nombrePlan)
        var precio:TextView = findViewById(R.id.nombrePrecio)

        nomDestino.text = destino.getString("nombre")
        pais.text = destino.getString("pais")
        categoria.text = destino.getString("categoria")
        plan.text = destino.getString("plan")
        precio.text = destino.getString("precio")
    }

    fun findDestinoByName(nomIntent: String): JSONObject {
        for (i in 0 until Data.ARREGLO_DESTINOS.length()){
            var elemento:JSONObject =Data.ARREGLO_DESTINOS.getJSONObject(i)
            if (elemento.getString("nombre") == nomIntent){
                return Data.ARREGLO_DESTINOS.getJSONObject(i)
            }
        }
        return JSONObject()
    }
}