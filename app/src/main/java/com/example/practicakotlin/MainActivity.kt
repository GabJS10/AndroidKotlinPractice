package com.example.practicakotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicakotlin.ImcCalculator.ImcCalculatorActivity
import com.example.practicakotlin.firstapp.FirstAppActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludoApp = findViewById<Button>(R.id.btnSaludoApp)
        val btnImc = findViewById<Button>(R.id.btnImc)

        btnSaludoApp.setOnClickListener{
            val intent = Intent(this,FirstAppActivity::class.java)
            startActivity(intent)
        }


        btnImc.setOnClickListener {
            val intent = Intent(this,ImcCalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}