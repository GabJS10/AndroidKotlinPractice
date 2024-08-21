package com.example.practicakotlin.ImcCalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicakotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var selectMujer:CardView
    private lateinit var selectHombre:CardView
    private lateinit var rgAltura:RangeSlider
    private lateinit var txtAltura:TextView
    private lateinit var txtAge:TextView
    private lateinit var txtWeight:TextView
    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var btnSumarPeso: FloatingActionButton
    private lateinit var btnRestarPeso: FloatingActionButton
    private lateinit var btnCalcular:Button
    private  var edad:Int = 0
    private  var peso:Int = 0
    private var altura:Int = 0

    companion object {
        const val imc_key = "resultado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    private fun initComponents(){
        selectMujer=findViewById(R.id.selectMujer)
        selectHombre=findViewById(R.id.selectHombre)
        rgAltura=findViewById(R.id.rgAltura)
        txtAltura=findViewById(R.id.txtAltura)
        txtAge=findViewById(R.id.txtAge)
        txtAge.text = "0"
        btnSumarEdad=findViewById(R.id.btnSumarEdad)
        btnRestarEdad=findViewById(R.id.btnRestarEdad)
        txtWeight=findViewById(R.id.txtWeight)
        txtWeight.text = "0"
        btnSumarPeso=findViewById(R.id.btnSumarPeso)
        btnRestarPeso=findViewById(R.id.btnRestarPeso)
        btnCalcular=findViewById(R.id.btnCalcular)

    }

    private fun initListeners(){
        selectMujer.setOnClickListener { changeSelectedColor(selectMujer,selectHombre) }
        selectHombre.setOnClickListener { changeSelectedColor(selectHombre,selectMujer) }
        rgAltura.addOnChangeListener { _, value, _ -> changeTxtAltura(value)}
        btnSumarEdad.setOnClickListener{changeEdad("+")}
        btnRestarEdad.setOnClickListener{changeEdad("-")}
        btnSumarPeso.setOnClickListener{changeWeight("+")}
        btnRestarPeso.setOnClickListener{changeWeight("-")}
        btnCalcular.setOnClickListener{navigateToResult(calcular())}
    }

    private fun calcular():Double{
        var result = peso / (altura.toDouble()/100 * altura.toDouble()/100)
        val dc = DecimalFormat("#.#")
        var resultFormat = dc.format(result)
        return resultFormat.toDouble()
    }


    private fun navigateToResult(result:Double){
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra(imc_key,result)
        startActivity(intent)

    }

    private fun changeEdad(operation:String){
        if (operation=="+"){
            edad+=1
        }else{
            edad-=1
        }

        edad = if (edad<0)  0 else  edad

        txtAge.text=edad.toString()
    }

    private fun changeWeight(operation:String){
        if (operation=="+"){
            peso+=1
        }else{
            peso-=1
        }

        peso = if (peso<0)  0 else  peso

        txtWeight.text=peso.toString()
    }

    private fun changeSelectedColor(selected:CardView,noSelected:CardView){
        selected.setBackgroundColor(ContextCompat.getColor(this,R.color.background_component_selected))
        noSelected.setBackgroundColor(ContextCompat.getColor(this,R.color.background_component))
    }

    private fun changeTxtAltura(value:Float){
        altura = value.toInt()
        txtAltura.text="${altura.toString()}CM"
    }


}