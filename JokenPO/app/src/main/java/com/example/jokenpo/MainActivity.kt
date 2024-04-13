package com.example.jokenpo


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var btnPedra : ImageButton
    lateinit var btnPapel : ImageButton
    lateinit var btnTesoura : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnPapel)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnPedra = findViewById(R.id.btnPedra)
        btnPapel = findViewById(R.id.btnPapel)
        btnTesoura = findViewById(R.id.btnTesoura)

        fun iniciarTelaResultado(escolha: String) {
            val intent = Intent(applicationContext, tela_resultado::class.java)
            intent.putExtra("escolha", escolha)
            startActivity(intent)
        }

        btnPedra.setOnClickListener { iniciarTelaResultado("Pedra") }
        btnPapel.setOnClickListener { iniciarTelaResultado("Papel") }
        btnTesoura.setOnClickListener { iniciarTelaResultado("Tesoura") }
    }
}