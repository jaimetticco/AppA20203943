package com.admin.appa20203943.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.admin.appa20203943.db.dao.PacienteDao
import com.admin.appa20203943.db.entity.PacienteEntity
import com.admin.appa20203943.utilitarios.Constantes

@Database(entities = [PacienteEntity::class], version = 1)
public abstract class FilaExamenRoomDB: RoomDatabase() {
    abstract fun pacienteDao(): PacienteDao

    companion object{
        @Volatile
        private var INSTANCE: FilaExamenRoomDB? = null

        fun getDatabase(context: Context):FilaExamenRoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FilaExamenRoomDB::class.java,
                    Constantes().BD_PACIENTE
                ).build()
                INSTANCE = instance
                return  instance
            }
        }

    }
}