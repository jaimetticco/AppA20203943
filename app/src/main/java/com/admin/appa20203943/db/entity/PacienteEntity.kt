package com.admin.appa20203943.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbpaciente")
data class PacienteEntity(
    @PrimaryKey
    val codpaciente: Int,
    var password: String,
    var nomapellido: String,
    var celular: String

)
