package com.admin.appa20203943.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.admin.appa20203943.retrofit.AppA20203943Cliente
import com.admin.appa20203943.retrofit.response.PhotoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository {

    var responsePhoto = MutableLiveData<List<PhotoResponse>>()
    //
    fun photos(): MutableLiveData<List<PhotoResponse>> {

        val call: Call<List<PhotoResponse>> = AppA20203943Cliente
            .retrofitService.Photos()

        call.enqueue(object: Callback<List<PhotoResponse>> {
            override fun onResponse(
                call: Call<List<PhotoResponse>>,
                response: Response<List<PhotoResponse>>
            ) {
                responsePhoto.value = response.body()
            }
            override fun onFailure(call: Call<List<PhotoResponse>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }
        })
        return responsePhoto
    }
}