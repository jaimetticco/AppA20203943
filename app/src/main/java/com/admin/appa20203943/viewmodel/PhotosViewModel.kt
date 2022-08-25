package com.admin.appa20203943.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.admin.appa20203943.repository.PhotoRepository
import com.admin.appa20203943.retrofit.response.PhotoResponse

class PhotosViewModel: ViewModel() {
    private var repository = PhotoRepository()

    fun photos(): LiveData<List<PhotoResponse>> {
        return repository.photos()
    }
}