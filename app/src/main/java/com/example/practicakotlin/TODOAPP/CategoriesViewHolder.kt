package com.example.practicakotlin.TODOAPP

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practicakotlin.R

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val txtTitleCard:TextView = view.findViewById(R.id.txtTitleCard)
    private val vwLineCard:View = view.findViewById(R.id.vwLineCard)

fun render(taskCategory: TaskCategory){

    when(taskCategory){
        TaskCategory.Bussines -> {
            txtTitleCard.text = "Bussiness"
            vwLineCard.setBackgroundColor(ContextCompat.getColor(vwLineCard.context,R.color.todo_business_category))
        }
        TaskCategory.Other -> {
            txtTitleCard.text = "Other"
            vwLineCard.setBackgroundColor(ContextCompat.getColor(vwLineCard.context,R.color.todo_other_category))
        }
        TaskCategory.Personal -> {
            txtTitleCard.text = "Personal"
            vwLineCard.setBackgroundColor(ContextCompat.getColor(vwLineCard.context,R.color.todo_personal_category))
        }
    }
}
}