package com.yanshin.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yanshin.todoapp.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao() : ToDoDao

}