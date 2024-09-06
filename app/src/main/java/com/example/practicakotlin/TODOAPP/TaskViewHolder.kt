package com.example.practicakotlin.TODOAPP

import android.content.res.ColorStateList
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practicakotlin.R

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val chkSelected = view.findViewById<CheckBox>(R.id.chkSelected)
    val txtTitleCardTask = view.findViewById<TextView>(R.id.txtTitleCardTask)


    fun render(task: Task) {

        if (task.isSelected) {
            txtTitleCardTask.paintFlags = txtTitleCardTask.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            txtTitleCardTask.paintFlags = txtTitleCardTask.paintFlags and android.graphics.Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        chkSelected.isChecked = task.isSelected

        val color = when (task.category) {
            TaskCategory.Bussines -> R.color.todo_business_category
            TaskCategory.Personal -> R.color.todo_personal_category
            TaskCategory.Other -> R.color.todo_other_category

        }

        chkSelected.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(chkSelected.context, color))

        txtTitleCardTask.text = task.name


    }

}