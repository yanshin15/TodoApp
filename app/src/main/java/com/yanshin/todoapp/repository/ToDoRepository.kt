package com.yanshin.todoapp.repository

import androidx.room.Query
import com.yanshin.todoapp.data.ToDoDao
import com.yanshin.todoapp.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    val getAllTasks : Flow<List<TodoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority : Flow<List<TodoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority : Flow<List<TodoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTask> {
        return toDoDao.getSelectedTask(taskId)
    }

    suspend fun addTasK(toDoTask: TodoTask){
        toDoDao.addTask(toDoTask)
    }
    suspend fun updateTasK(toDoTask: TodoTask){
        toDoDao.updateTask(toDoTask)
    }
    suspend fun deleteTasK(toDoTask: TodoTask){
        toDoDao.deleteTask(toDoTask)
    }
    suspend fun deleteAllTasKs(){
        toDoDao.deleteAllTasks()
    }
    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>>{
        return toDoDao.searchDatabase(searchQuery)


    }

}