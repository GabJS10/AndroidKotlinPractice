package com.example.practicakotlin.TODOAPP

data class Task (val name:String,val category: TaskCategory,var isSelected:Boolean = false)