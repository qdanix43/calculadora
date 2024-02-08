package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    private var peso: Int = 50
    private lateinit var textViewPeso: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewPeso = findViewById(R.id.textViewPeso)
        actualizarTextoPeso()
    }

    fun subirPeso(view: android.view.View) {
        peso++
        actualizarTextoPeso()
    }

    fun bajarPeso(view: android.view.View) {
        peso--
        actualizarTextoPeso()
    }

    private fun actualizarTextoPeso() {
        textViewPeso.text = "Peso: $peso"
    }
}