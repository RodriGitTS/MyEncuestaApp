package com.example.myencuestaapp

import Modelo.Usuario
import Modelo.UsuarioDAO
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usuarioDAO():UsuarioDAO


}