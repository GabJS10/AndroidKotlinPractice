package com.example.practicakotlin.ImcCalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicakotlin.R
import   com.example.practicakotlin.ImcCalculator.ImcCalculatorActivity.Companion.imc_key
class ResultActivity : AppCompatActivity() {
    private lateinit var txtDescription:TextView
    private lateinit var txtResultado:TextView
    private lateinit var txtCategoria:TextView
    private lateinit var btnRecalcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         var result = intent.getDoubleExtra(imc_key,-1.0)
        initComponents()
        initUi(result)
        initListeners()
    }

    private fun initListeners(){
        btnRecalcular.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initComponents(){
        txtCategoria= findViewById(R.id.txtCategoria)
        txtResultado= findViewById(R.id.txtResultado)
        txtDescription= findViewById(R.id.txtDecription)
        btnRecalcular = findViewById(R.id.btnReCalcular)
    }

    private fun initUi(result:Double){
        txtResultado.text = result.toString()
        when(result){
            in 0.00..18.50 -> { //Bajo peso
                txtCategoria.text = getString(R.string.title_bajo_peso)
                txtCategoria.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                txtDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> { //Peso normal
                txtCategoria.text = getString(R.string.title_peso_normal)
                txtCategoria.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                txtDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> { //Sobrepeso
                txtCategoria.text = getString(R.string.title_sobrepeso)
                txtCategoria.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                txtDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00 -> { //Obesidad
                txtCategoria.text = getString(R.string.title_obesidad)
                txtCategoria.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                txtDescription.text = getString(R.string.description_obesidad)
            }
            else -> {//error
                txtResultado.text = getString(R.string.error)
                txtCategoria.text = getString(R.string.error)
                txtCategoria.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                txtDescription.text = getString(R.string.error)
            }
                }
        }



}