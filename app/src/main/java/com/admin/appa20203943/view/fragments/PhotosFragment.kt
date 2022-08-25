package com.admin.appa20203943.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.admin.appa20203943.R
import com.admin.appa20203943.databinding.FragmentPhotosBinding
import com.admin.appa20203943.retrofit.response.PhotoResponse
import com.admin.appa20203943.view.adapters.PhotosAdapter
import com.admin.appa20203943.viewmodel.PhotosViewModel


class PhotosFragment : Fragment() {
    private var _binding : FragmentPhotosBinding? = null
    private val binding get() = _binding!!
    private lateinit var photosViewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotosBinding.inflate(
            inflater,container,false
        )

        photosViewModel = ViewModelProvider(requireActivity())
            .get(PhotosViewModel::class.java)


        binding.rvphotos.layoutManager = LinearLayoutManager(
            requireActivity())

        photosViewModel.photos().observe(viewLifecycleOwner, Observer { response ->
            listarPhotos(response)
        })

        return binding.root
    }
    //
    private fun listarPhotos(response: List<PhotoResponse>?) {

        var lstPhotos:MutableList<PhotoResponse> = ArrayList()

        for(photo: PhotoResponse in response!!){
            if(photo.albumId % 2 == 0){
                lstPhotos.add(photo)
            }
        }
        binding.rvphotos.adapter = PhotosAdapter(lstPhotos)
    }


}