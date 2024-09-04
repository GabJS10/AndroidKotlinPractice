package com.example.practicakotlin.TODOAPP

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicakotlin.R

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val chkSelected = view.findViewById<CheckBox>(R.id.chkSelected)
    val txtTitleCardTask = view.findViewById<TextView>(R.id.txtTitleCardTask)


    fun render(task: Task) {
        txtTitleCardTask.text = task.name
    }

}