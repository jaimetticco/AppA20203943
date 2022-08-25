package com.admin.appa20203943.retrofit

import com.admin.appa20203943.retrofit.response.PhotoResponse
import com.admin.appa20203943.retrofit.response.TodosResponse
import retrofit2.Call
import retrofit2.http.GET

interface AppA20203943Service {

    @GET("todos")
    fun Todos(): Call<List<TodosResponse>>

    @GET("photos")
    fun Photos(): Call<List<PhotoResponse>>
}