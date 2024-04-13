package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textoPergunta: TextView
    private lateinit var textoResposta1: Button
    private lateinit var textoResposta2: Button
    private lateinit var textoResposta3: Button

    private var indicePerguntaAtual = 0

    private val perguntas = listOf(
        Pergunta("Quando que o Thiago para de bater na mesa? ", "Nunca", listOf("Sempre","Nunca","As vezes")),
        Pergunta("Quando essa turma vao se formar? ", "2025", listOf("2025","Nunca","2024")),
        Pergunta("Quem é o representante da Sala? ", "Remendo", listOf("Orlando","Remendo","Chiara"))

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textoPergunta = findViewById(R.id.textoPergunta)
        textoResposta1 = findViewById(R.id.btnResp1)
        textoResposta2 = findViewById(R.id.btnResp2)
        textoResposta3 = findViewById(R.id.btnResp3)
        atualizarPergunta()

        textoResposta1.setOnClickListener { verificarResposta(perguntas[indicePerguntaAtual].respostas[0]) }
        textoResposta2.setOnClickListener { verificarResposta(perguntas[indicePerguntaAtual].respostas[1]) }
        textoResposta3.setOnClickListener { verificarResposta(perguntas[indicePerguntaAtual].respostas[2]) }
    }
    private fun atualizarPergunta(){
        val perguntaAtual = perguntas[indicePerguntaAtual]
        textoPergunta.text = perguntaAtual.texto
        textoResposta1.text = perguntaAtual.respostas[0]
        textoResposta2.text = perguntaAtual.respostas[1]
        textoResposta3.text = perguntaAtual.respostas[2]
    }
    private fun verificarResposta(resposta: String){
        val mensagem = if(resposta == perguntas[indicePerguntaAtual].respostaCorreta){
            "Correto!!"
        }else{
            "Incorreto!!"
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        indicePerguntaAtual = (indicePerguntaAtual + 1) % perguntas.size
        atualizarPergunta()

    }

}