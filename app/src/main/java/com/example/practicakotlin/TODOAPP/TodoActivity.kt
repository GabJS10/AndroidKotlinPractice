package com.example.practicakotlin.TODOAPP

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        adapter = CategoriesAdapter(categories) { position -> onCategorySelected(position) }
        rcvCategorias.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rcvCategorias.adapter = adapter


        task_adapter = TaskAdapter(tasks){position -> onItemSelected(position)}
        rcvTareas.layoutManager = LinearLayoutManager(this)
        rcvTareas.adapter = task_adapter

    }

    private fun initListeners(){
        btnAddTask.setOnClickListener {showDialog()}
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_task)

        val btnAddTask = dialog.findViewById<Button>(R.id.btnAddTask)
        val etTask = dialog.findViewById<EditText>(R.id.txtTask)
        val rgCategories = dialog.findViewById<RadioGroup>(R.id.rgCategories)

        btnAddTask.setOnClickListener{

            if(etTask.text.toString().isEmpty()){
                return@setOnClickListener
            }

            val selectedId = rgCategories.checkedRadioButtonId
            val selectedRadioButton = rgCategories.findViewById<RadioButton>(selectedId)

            val selectedCategory:TaskCategory = when(selectedRadioButton.text){
                getString(R.string.todo_dialog_category_business) -> TaskCategory.Bussines
                getString(R.string.todo_dialog_category_personal) -> TaskCategory.Personal
                else -> TaskCategory.Other
            }

            tasks.add(Task(etTask.text.toString(),selectedCategory))
            task_adapter.notifyDataSetChanged()
            dialog.hide()
        }



        dialog.show()

    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        task_adapter.notifyDataSetChanged()
    }

    private fun onCategorySelected(position:Int){
        categories[position].selected = !categories[position].selected
        adapter.notifyItemChanged( position)

        val selectedCategories:List<TaskCategory> = categories.filter { it.selected }

        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        task_adapter.tasks = newTasks

        task_adapter.notifyDataSetChanged()
    }


}