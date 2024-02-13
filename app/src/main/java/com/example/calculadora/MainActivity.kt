package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private var peso: Int = 50
    private var altura: Int = 150
    private lateinit var seekBar: SeekBar
    private lateinit var textViewPeso: TextView
    private lateinit var textViewAltura: TextView
    private lateinit var miBotonCualquiera: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewPeso = findViewById(R.id.textViewPeso)
        actualizarTextoPeso()
        textViewAltura = findViewById(R.id.textView1)
        seekBar = findViewById(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                altura = progress
                actualizarTextoAltura()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        miBotonCualquiera = findViewById(R.id.buttonCalcular)
        textViewResultado = findViewById(R.id.textViewResultado)

        miBotonCualquiera.setOnClickListener {textViewResultado
            val resultado = calcularIMC()
            textViewResultado.text = "Tu IMC es de $resultado"
        }
    }

    fun subirPeso(view: View) {
        peso++
        actualizarTextoPeso()
    }

    fun bajarPeso(view: View) {
        peso--
        actualizarTextoPeso()
    }

    fun subirAltura(view: View) {
        altura++
        actualizarTextoAltura()
        seekBar.progress = altura
    }

    fun bajarAltura(view: View) {
        altura--
        actualizarTextoAltura()
        seekBar.progress = altura
    }

    private fun actualizarTextoPeso() {
        textViewPeso.text = "Peso: $peso kg"
    }

    private fun actualizarTextoAltura() {
        textViewAltura.text = "Altura: ${(altura / 100f)} m"
    }

    private fun calcularIMC(): String {
        val resultado = peso / (altura / 100f).pow(2)
        return resultado.toString()
    }
}

