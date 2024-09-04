package com.example.practicakotlin.TODOAPP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicakotlin.R

class CategoriesAdapter(private val categories:List<TaskCategory>)
    : RecyclerView.Adapter<CategoriesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_todo,parent,false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        return holder.render(categories[position])
    }
}