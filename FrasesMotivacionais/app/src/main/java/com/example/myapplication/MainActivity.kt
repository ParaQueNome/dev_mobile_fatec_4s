package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // criando variável para ser utilizada em qualquer ponto do código
    lateinit var texto: TextView
    //inicializando vetor com frases motivacionais
    val frases = arrayListOf("Se disserem que não consegue, vá e mostre que falaram a verdade!","A última vez que me perdi, não sabia onde estava",
        "Algo de errado não está certo...", "Se te ofenderam sem merecer, vá lá e mereça!")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //funcao responsavel por gerar a frase motivacional e exibir
    fun gerarFrases(view: View){
        // alocando tamanho do vetor de frases no objeto
        val vetor = frases.size
        //criando variavel para gerar numeros aleatorios no array de acordo com seu tamanho
        val numAleatorio = Random.nextInt(vetor)
        // alocando o texto com a frase gerada aleatoriamente pelo indice do vetor
        texto.setText(frases[numAleatorio])
    }
    //funcao responsavel por limpar o texto
    fun apargarFrases(view: View){
        //criando variavel que vai substituir o texto por vazio
        texto.setText("")
    }
}