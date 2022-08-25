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
import com.admin.appa20203943.databinding.FragmentTodosBinding
import com.admin.appa20203943.retrofit.response.TodosResponse
import com.admin.appa20203943.view.adapters.TodosAdapter
import com.admin.appa20203943.viewmodel.TodosViewModel


class TodosFragment : Fragment() {
    private var _binding: FragmentTodosBinding? = null
    private val binding get() = _binding!!
    private lateinit var todosViewModel:TodosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodosBinding.inflate(
            inflater,container,false
        )

        todosViewModel = ViewModelProvider(requireActivity())
            .get(TodosViewModel::class.java)

        binding.rvtodos.layoutManager = LinearLayoutManager(
            requireActivity())

        todosViewModel.todos().observe(viewLifecycleOwner, Observer { response ->
            listarTodos(response)
        })
        return binding.root
    }
    //
    private fun listarTodos(response: List<TodosResponse>?) {

        var lstTodos:MutableList<TodosResponse> = ArrayList()

        for(todo:TodosResponse in response!!){
            if(todo.userId % 2 == 1){
                lstTodos.add(todo)
            }
        }
        binding.rvtodos.adapter = TodosAdapter(lstTodos)
    }


}