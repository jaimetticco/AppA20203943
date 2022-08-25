package com.admin.appa20203943.repository

import androidx.lifecycle.LiveData
import com.admin.appa20203943.db.dao.PacienteDao
import com.admin.appa20203943.db.entity.PacienteEntity

class PacienteRepository(private val pacienteDao: PacienteDao) {

    suspend fun insertar(pacienteEntity: PacienteEntity){
        pacienteDao.agregarPaciente(pacienteEntity)
    }

    fun obtener(): LiveData<PacienteEntity> {
        return pacienteDao.obtenerPaciente()
    }
}