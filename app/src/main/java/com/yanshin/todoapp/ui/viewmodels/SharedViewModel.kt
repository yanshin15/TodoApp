package com.yanshin.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yanshin.todoapp.models.TodoTask
import com.yanshin.todoapp.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository : ToDoRepository) : ViewModel() {
    private val _allTasks = MutableStateFlow<List<TodoTask>>(emptyList())
    val allTasks : StateFlow<List<TodoTask>> = _allTasks


    fun getAllTasks(){
        viewModelScope.launch {
            repository.getAllTasks.collect{
                _allTasks.value = it

            }
        }
    }
}