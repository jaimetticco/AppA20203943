package com.admin.appa20203943.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.admin.appa20203943.retrofit.AppA20203943Cliente
import com.admin.appa20203943.retrofit.response.TodosResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodosRepository {
    var todosResponse = MutableLiveData<List<TodosResponse>>()
    //
    fun todos(): MutableLiveData<List<TodosResponse>> {

        val call: Call<List<TodosResponse>> = AppA20203943Cliente
            .retrofitService.Todos()

        call.enqueue(object: Callback<List<TodosResponse>> {
            override fun onResponse(
                call: Call<List<TodosResponse>>,
                response: Response<List<TodosResponse>>
            ) {
                todosResponse.value = response.body()
            }

            override fun onFailure(call: Call<List<TodosResponse>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }
        })
        return todosResponse
    }
}