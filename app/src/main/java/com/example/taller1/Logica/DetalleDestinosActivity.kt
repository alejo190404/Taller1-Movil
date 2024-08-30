package com.example.taller1.Logica

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1.Datos.Data
import com.example.taller1.R
import org.json.JSONObject

class DetalleDestinosActivity : AppCompatActivity() {
    private lateinit var nomDestino: TextView
    private lateinit var pais: TextView
    private lateinit var categoria: TextView
    private lateinit var plan: TextView
    private lateinit var precio: TextView
    private lateinit var boton: Button
    private lateinit var nomIntent: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_destinos)

        nomIntent = intent.getStringExtra("destino")!!

        val destino: JSONObject = findDestinoByName(nomIntent)

        getViews()
        initializeButton(boton)
        setDestinationDetails(destino)

        boton.setOnClickListener{
            markButtonDisable(boton)
            anadirFavoritos(destino)
            Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun anadirFavoritos(destino: JSONObject) {
        Data.ARREGLO_FAVORITOS.add(destino)
        for (i in 0 until Data.ARREGLO_FAVORITOS.size){
            Log.i("Elemento $i", Data.ARREGLO_FAVORITOS[i].toString())
        }
    }

    private fun initializeButton(boton: Button) {
        for (i in 0 until Data.ARREGLO_FAVORITOS.size){
            val elemento: JSONObject = Data.ARREGLO_FAVORITOS[i]
            if (elemento.getString("nombre") == nomIntent) {
                markButtonDisable(boton)
            }
        }
    }

    fun markButtonDisable(button: Button) {
        button?.isEnabled = false
        button?.isClickable = false
    }

    private fun getViews() {
        nomDestino = findViewById(R.id.nombreDestino)
        pais = findViewById(R.id.nombrePais)
        categoria = findViewById(R.id.nombreCategoria)
        plan = findViewById(R.id.nombrePlan)
        precio = findViewById(R.id.nombrePrecio)
        boton = findViewById(R.id.botonAnadirFavoritos)
    }

    private fun setDestinationDetails(destino: JSONObject) {
        nomDestino.text = destino.getString("nombre")
        pais.text = destino.getString("pais")
        categoria.text = destino.getString("categoria")
        plan.text = destino.getString("plan")
        precio.text = destino.getString("precio")
    }

    private fun findDestinoByName(nomIntent: String): JSONObject {
        for (i in 0 until Data.ARREGLO_DESTINOS.length()) {
            val elemento: JSONObject = Data.ARREGLO_DESTINOS.getJSONObject(i)
            if (elemento.getString("nombre") == nomIntent) {
                return elemento
            }
        }
        return JSONObject()
    }
}