package com.example.practicakotlin.TODOAPP

import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicakotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
    private lateinit var rcvCategorias:RecyclerView
    private lateinit var rcvTareas:RecyclerView
    private lateinit var btnAddTask: FloatingActionButton
    private val categories = listOf(
        TaskCategory.Personal,
        TaskCategory.Bussines,
        TaskCategory.Other
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness",TaskCategory.Bussines),
        Task("PruebaPersonal",TaskCategory.Personal),
        Task("PruebaOther",TaskCategory.Other)
    )

    private lateinit var adapter:CategoriesAdapter
    private lateinit var task_adapter:TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initUi()
        initListeners()
    }


    private fun initComponents(){
        rcvCategorias = findViewById<RecyclerView>(R.id.rcvCategorias)
        rcvTareas = findViewById<RecyclerView>(R.id.rcvTareas)
        btnAddTask = findViewById<FloatingActionButton>(R.id.btnAddTask)
    }

    private fun initUi(){
        adapter = CategoriesAdapter(categories)
        rcvCategorias.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rcvCategorias.adapter = adapter


        task_adapter = TaskAdapter(tasks)
        rcvTareas.layoutManager = LinearLayoutManager(this)
        rcvTareas.adapter = task_adapter

    }

    private fun initListeners(){
        btnAddTask.setOnClickListener {showDialog()}
    }

    private fun showDialog(){
        val dialog = Dialog(this)

    }



}