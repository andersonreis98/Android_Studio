package com.example.sorteiokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sorteia(view: View){
        var aleatorio = Random.nextInt(10)
        var text = findViewById<TextView>(R.id.textViewResultado)
        text.setText("numero sorteado: "+aleatorio)

    }
}