package Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
class Usuario(
    @PrimaryKey override var dni:String, nombre: String, edad: Int, var password: String
): Persona(dni, nombre, edad)


