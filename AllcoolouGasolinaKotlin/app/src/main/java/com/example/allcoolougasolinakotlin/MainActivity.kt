package com.example.allcoolougasolinakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcular(view : View){

//        Recupera valores digitados
        var precoAlcool = editTextTextPersonName.text.toString()
        var precoGasolina = editTextTextPersonName2.text.toString()

        var validarCampos = validarCampos(precoAlcool,precoGasolina)
        if (validarCampos){
            calcularMelhorPreco(precoAlcool,precoGasolina)
        }else{
            textViewResultado.text = "Preencha os preços primeiro!"
        }
    }
    fun validarCampos(precoAlcool : String,precoGasolina : String) : Boolean{

        var camposValidados:Boolean = true
        if (precoAlcool==null||precoAlcool.equals("")){
            camposValidados = false
        }
        if (precoGasolina==null||precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }
    fun calcularMelhorPreco(precoAlcool : String,precoGasolina : String){
        val alcool = precoAlcool.toDouble()
        val gasolina = precoGasolina.toDouble()
        val resultadoPreco = alcool/gasolina

        if (resultadoPreco >= 0.7){

            textViewResultado.text = "Melhor utilizar Gasolina"

        }else{
            textViewResultado.text = "Melhor utilizar Alcool"
        }
    }
}