package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var opcion: Any

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar arreglo global de destinos
        Data.initialize(baseContext)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.onItemSelectedListener = this

        val botonExplorar:Button = findViewById(R.id.botonExplorar)
        val botonFavoritos:Button = findViewById(R.id.botonFavoritos)
        val botonRecomendaciones:Button = findViewById(R.id.botonRecomendaciones)

        botonExplorar.setOnClickListener{
            crearIntentExplorar()
        }

        botonFavoritos.setOnClickListener{
            crearIntentFavoritos()
        }

        botonRecomendaciones.setOnClickListener{
            crearIntentRecomendaciones()
        }

    }

    private fun crearIntentExplorar(){
        val intent = Intent(this, ListaDestinosActivity::class.java)
        intent.putExtra("opcion", opcion.toString())
        startActivity(intent)
    }

    private fun crearIntentFavoritos(){

    }

    private fun crearIntentRecomendaciones(){

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        opcion = parent!!.selectedItem
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        opcion = parent!!.getItemAtPosition(0)
    }
}