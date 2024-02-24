package com.example.random_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sortearNumero(view:View){
        val texto = findViewById<TextView>(R.id.textResultado)
        val sortearNumero = (1..99).random()
        texto.text = "O resultado é: $sortearNumero"
    }
}