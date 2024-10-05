package Modelo

import androidx.room.Entity

@Entity(tableName = "usuarios")
class Usuario(dni:String, nombre: String, edad: Int, var password: String
): Persona(dni, nombre, edad)


