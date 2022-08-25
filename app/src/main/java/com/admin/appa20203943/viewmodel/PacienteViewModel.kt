package com.admin.appa20203943.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.admin.appa20203943.db.FilaExamenRoomDB
import com.admin.appa20203943.db.entity.PacienteEntity
import com.admin.appa20203943.repository.PacienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PacienteViewModel(application: Application)
    :AndroidViewModel(application)
{
    private val pacienteRepository: PacienteRepository

    init {
        val pacienteDao = FilaExamenRoomDB.getDatabase(application)
            .pacienteDao()
        pacienteRepository = PacienteRepository(pacienteDao)
    }

    fun insertar(pacienteEntity: PacienteEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            pacienteRepository.insertar(pacienteEntity)
        }

    fun obtener(): LiveData<PacienteEntity> {
        return pacienteRepository.obtener()
    }
}