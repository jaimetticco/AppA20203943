package com.admin.appa20203943.retrofit

import com.admin.appa20203943.utilitarios.Constantes
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppA20203943Cliente {

    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES)
        .build()

    private fun buildRetrofit()= Retrofit.Builder()
        .baseUrl(Constantes().API_RETROFIT)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService:AppA20203943Service by lazy {
        buildRetrofit().create(AppA20203943Service::class.java)
    }
}