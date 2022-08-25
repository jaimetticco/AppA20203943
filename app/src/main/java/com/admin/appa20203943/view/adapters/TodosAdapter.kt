package com.admin.appa20203943.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admin.appa20203943.databinding.ItemTodosBinding
import com.admin.appa20203943.retrofit.response.TodosResponse

class TodosAdapter(private var lstTodos: List<TodosResponse>)
    :RecyclerView.Adapter<TodosAdapter.ViewHolder>()
{
    inner class ViewHolder(val binding: ItemTodosBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTodosBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){

            with(lstTodos[position]){
                binding.txvidtodo.text = "id: "+id.toString()
                binding.txvuserid.text = "userId: "+userId.toString()
                binding.txvtitletodo.text = "title: "+title
                binding.txvcompleted.text = "completed: "+completed
            }
        }
    }

    override fun getItemCount(): Int {
        return lstTodos.size
    }
}