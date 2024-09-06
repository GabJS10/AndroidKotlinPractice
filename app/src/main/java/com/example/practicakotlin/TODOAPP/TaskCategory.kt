package com.example.practicakotlin.TODOAPP

sealed class TaskCategory(var selected:Boolean = true) {
    data object Personal:TaskCategory()
    data object Bussines:TaskCategory()
    data object Other:TaskCategory()

}