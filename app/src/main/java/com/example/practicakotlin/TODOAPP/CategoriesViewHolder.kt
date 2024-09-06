package com.example.practicakotlin.TODOAPP

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practicakotlin.R

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val txtTitleCard:TextView = view.findViewById(R.id.txtTitleCard)
    private val vwLineCard:View = view.findViewById(R.id.vwLineCard)
    private val cardCategory: CardView = view.findViewById(R.id.cardCategory)
fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

    if(taskCategory.selected){
        cardCategory.setCardBackgroundColor(ContextCompat.getColor(cardCategory.context,R.color.todo_background_card))
    }else{
        cardCategory.setCardBackgroundColor(ContextCompat.getColor(cardCategory.context,R.color.todo_background_disabled))
    }

    itemView.setOnClickListener{onItemSelected(layoutPosition)}

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