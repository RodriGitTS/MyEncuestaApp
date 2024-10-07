package com.example.myencuestaapp

import Modelo.Encuesta
import Modelo.EncuestaDAO
import Modelo.Usuario
import Modelo.UsuarioDAO
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class, Encuesta::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun encuestaDAO(): EncuestaDAO
}
