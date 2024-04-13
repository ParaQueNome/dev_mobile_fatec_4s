package com.example.numerodado



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
        setContentView(R.layout.tela_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnVolta = findViewById(R.id.btnRetorno)
        imgResultado = findViewById(R.id.img1)

        val dados : Bundle? = intent.extras
        val numero = dados?.getInt("numero")

        if(numero == 0){
            imgResultado.setImageResource(R.drawable.dado1)
        }else if(numero ==1){
            imgResultado.setImageResource(R.drawable.dado2)

        }else if(numero ==2){
            imgResultado.setImageResource(R.drawable.dado3)
        }else if(numero ==3){
            imgResultado.setImageResource(R.drawable.dado4)
        }else if(numero ==4){
            imgResultado.setImageResource(R.drawable.dado5)
        }else{
            imgResultado.setImageResource(R.drawable.dado6)
        }
        btnVolta.setOnClickListener {
            finish()

        }
    }
}