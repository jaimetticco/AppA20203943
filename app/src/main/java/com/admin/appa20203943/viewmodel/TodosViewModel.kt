package com.admin.appa20203943.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.admin.appa20203943.repository.TodosRepository
import com.admin.appa20203943.retrofit.response.TodosResponse

class TodosViewModel: ViewModel() {
    private var repository = TodosRepository()

    fun todos(): LiveData<List<TodosResponse>> {
        return repository.todos()
    }
}