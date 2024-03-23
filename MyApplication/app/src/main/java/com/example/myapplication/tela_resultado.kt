package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class tela_resultado : AppCompatActivity() {

    lateinit var  btnVolta: ImageButton
    lateinit var imgResultado: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnVolta = findViewById(R.id.btnVoltar)
        imgResultado = findViewById(R.id.imgCara)

        val dados : Bundle? = intent.extras
        val numero = dados?.getInt("numero")

        if(numero == 0){
            imgResultado.setImageResource(R.drawable.cara)
        }else{
            imgResultado.setImageResource(R.drawable.coroa)

        }
        btnVolta.setOnClickListener {
            finish()

        }
    }
}