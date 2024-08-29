package com.example.taller1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class DetalleDestinosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_destinos)

        val destino = JSONObject(intent.getStringExtra("destino")!!)

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
}