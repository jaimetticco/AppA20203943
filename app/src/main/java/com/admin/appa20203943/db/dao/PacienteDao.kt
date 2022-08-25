package com.admin.appa20203943.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.admin.appa20203943.db.entity.PacienteEntity

@Dao
interface PacienteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun agregarPaciente(vararg paciente: PacienteEntity)


    @Query("SELECT * FROM tbpaciente LIMIT 1")
    fun obtenerPaciente(): LiveData<PacienteEntity>
}