package com.admin.appa20203943.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.admin.appa20203943.R
import com.admin.appa20203943.databinding.ActivityLoginBinding
import com.admin.appa20203943.db.entity.PacienteEntity
import com.admin.appa20203943.model.Paciente
import com.admin.appa20203943.viewmodel.PacienteViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var lstPaciente:List<Paciente>
    private var login = false
    private lateinit var pacienteViewModel: PacienteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        lstPaciente = crearLista()
        //
        pacienteViewModel = ViewModelProvider(this)
            .get(PacienteViewModel::class.java)

        binding.btninisiarsersion.setOnClickListener(this)

    }
    //
    private fun crearLista(): List<Paciente> {
        var paciente1 = Paciente(101, "123456", "Jaime Ttito", "963258741")
        var paciente2 = Paciente(102, "123456", "Raegar Targarean", "999666333")
        var paciente3 = Paciente(103, "123456", "Jonh Snow", "999888777")

        return listOf(paciente1, paciente2, paciente3)
    }
    //
    override fun onClick(view: View) {
        when(view.id){
            R.id.btninisiarsersion -> autenticarPaciente()
        }
    }
    //
    private fun autenticarPaciente() {
        validarPaciente()
        if(login){
            val intent = Intent(this,NavigationActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext,
                "Error el codigo paciente o password son incorrectos.", Toast.LENGTH_LONG).show()
        }
    }
    //
    private fun validarPaciente(){
        for(paciente: Paciente in lstPaciente){
            if(binding.edtcodigo.text.toString() == paciente.codpaciente.toString() &&
                binding.edtpassword.text.toString() == paciente.password){
                login = true
                agregarDBRoom(paciente)
                break
            }
        }
    }
    //
    private fun agregarDBRoom(paciente: Paciente){
        val pacienteEntity = PacienteEntity(paciente.codpaciente,paciente.password,paciente.nomapellido,paciente.celular)
        pacienteViewModel.insertar(pacienteEntity)
    }
}