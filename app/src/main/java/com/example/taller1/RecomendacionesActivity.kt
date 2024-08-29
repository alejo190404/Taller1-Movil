package com.example.taller1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class RecomendacionesActivity : AppCompatActivity() {
    private lateinit var nomDestino: TextView
    private lateinit var pais: TextView
    private lateinit var categoria: TextView
    private lateinit var plan: TextView
    private lateinit var precio: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendaciones)

        getViews()
        setDestinationDetails(selectRandom())
    }

    private fun selectRandom(): JSONObject {
        if (Data.ARREGLO_FAVORITOS.isEmpty())
            return JSONObject()

        val categoria:String = Data.ARREGLO_FAVORITOS[Data.ARREGLO_FAVORITOS.size - 1].getString("categoria")
        var elemento:JSONObject
        do {
            elemento = Data.ARREGLO_FAVORITOS.random()
        } while(elemento.getString("categoria") != categoria)
        return elemento
    }

    private fun getViews() {
        nomDestino = findViewById(R.id.nombreDestinoRecomendacion)
        pais = findViewById(R.id.nombrePaisRecomendacion)
        categoria = findViewById(R.id.nombreCategoriaRecomendacion)
        plan = findViewById(R.id.nombrePlanRecomendacion)
        precio = findViewById(R.id.nombrePrecioRecomendacion)
    }

    private fun setDestinationDetails(destino: JSONObject) {
        if (!destino.has("nombre")){
            return
        }
        else {
            nomDestino.text = destino.getString("nombre")
            pais.text = destino.getString("pais")
            categoria.text = destino.getString("categoria")
            plan.text = destino.getString("plan")
            precio.text = destino.getString("precio")
        }
    }

}