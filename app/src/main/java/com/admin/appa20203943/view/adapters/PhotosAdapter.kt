package com.admin.appa20203943.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admin.appa20203943.databinding.ItemPhotosBinding
import com.admin.appa20203943.retrofit.response.PhotoResponse
import com.bumptech.glide.Glide

class PhotosAdapter (private var lstPhotos: List<PhotoResponse>)
    :RecyclerView.Adapter<PhotosAdapter.ViewHolder>()
{
    inner class ViewHolder(val binding: ItemPhotosBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPhotosBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){

            with(lstPhotos[position]){
                binding.txvidphoto.text = "id: "+id.toString()
                binding.txvalbumid.text = "albumId: "+albumId.toString()
                binding.txvthumbnailUrl.text = "thumbnailUrl: "+thumbnailUrl
                binding.txvtitlephoto.text = "title: "+title

                Glide.with(itemView.context)
                    .load(thumbnailUrl)
                    .into(binding.imageViewPhotos)
            }
        }
    }

    override fun getItemCount(): Int {
        return lstPhotos.size
    }

}