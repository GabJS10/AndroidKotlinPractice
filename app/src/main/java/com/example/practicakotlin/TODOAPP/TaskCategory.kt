package com.example.practicakotlin.TODOAPP

sealed class TaskCategory {
    data object Personal:TaskCategory()
    data object Bussines:TaskCategory()
    data object Other:TaskCategory()

}