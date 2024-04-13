package com.example.jokenpo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class tela_resultado : AppCompatActivity() {
    lateinit var btnVolta : ImageButton
    lateinit var imgResultadoJogador : ImageView
    lateinit var  imgResultadoBot : ImageView
    lateinit var escolhaBotFormatada : String
    lateinit var textoResultado : TextView
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

        val escolhaBot = Random.nextInt(3)

        if(escolhaBot == 0){
            escolhaBotFormatada = "Pedra"
        }else if(escolhaBot == 1){
            escolhaBotFormatada = "Papel"
        }else{
            escolhaBotFormatada = "Tesoura"
        }

        val dados : Bundle? = intent.extras
        val escolhaJogador = dados?.getString("escolha")
        textoResultado = findViewById(R.id.resultado)
        imgResultadoJogador = findViewById(R.id.imgJogador)
        imgResultadoBot = findViewById(R.id.txtComputador)

        if(escolhaBotFormatada == "Pedra" && escolhaJogador == "Pedra"){
            imgResultadoBot.setImageResource(R.drawable.pedra_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.pedra_jokenpo)
            textoResultado.text = "O Resultado é: Pedra, foi um Empate!!!"

        }else if(escolhaBotFormatada == "Papel" && escolhaJogador=="Pedra"){
            imgResultadoBot.setImageResource(R.drawable.papel_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.pedra_jokenpo)
            textoResultado.text = "O Resultado é: Papel, você Perdeu!!"
        }else if(escolhaBotFormatada == "Pedra" && escolhaJogador== "Papel"){
            imgResultadoBot.setImageResource(R.drawable.pedra_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.papel_jokenpo)
            textoResultado.text = "O Resultado é: Papel, você Ganhou!!"
        }else if(escolhaBotFormatada == "Tesoura" && escolhaJogador=="Papel"){
            imgResultadoBot.setImageResource(R.drawable.tesoura_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.papel_jokenpo)
            textoResultado.text = "O Resultado é: Tesoura, você Perdeu!!"
        }else if(escolhaBotFormatada == "Papel" && escolhaJogador=="Tesoura"){
            imgResultadoBot.setImageResource(R.drawable.papel_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.tesoura_jokenpo)
            textoResultado.text = "O Resultado é: Tesoura, você Ganhou!!"
        }else if(escolhaBotFormatada == "Pedra" && escolhaJogador=="Tesoura"){
            imgResultadoBot.setImageResource(R.drawable.pedra_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.tesoura_jokenpo)
            textoResultado.text = "O Resultado é: Pedra, você Perdeu!!"
        }else{
            imgResultadoBot.setImageResource(R.drawable.tesoura_jokenpo)
            imgResultadoJogador.setImageResource(R.drawable.pedra_jokenpo)
            textoResultado.text = "O Resultado é: Pedra, você Ganhou!!"
        }
        btnVolta.setOnClickListener(){
            finish()
        }
    }
}