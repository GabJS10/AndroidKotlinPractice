package com.example.practicakotlin.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicakotlin.R
import kotlin.math.log

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btn = findViewById<AppCompatButton>(R.id.btnClickAqui)
        val areaText = findViewById<AppCompatEditText>(R.id.text1)


        btn.setOnClickListener{
            val txt = areaText.text.toString()


            if (txt.isNotEmpty()) {
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("name",txt)
                startActivity(intent)

            }

        }
    }
}
