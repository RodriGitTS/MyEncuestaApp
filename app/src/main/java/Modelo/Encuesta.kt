package Modelo

import androidx.room.Entity

import androidx.room.PrimaryKey

@Entity(tableName = "encuestas")
data class Encuesta(
    @PrimaryKey val usuario:String,
    val sistemaOperativo:String,
    val curso: String,
    val horasEstudio:Int



){
    override fun toString(): String {
        return "Encuesta(usuario='$usuario', sistemaOperativo='$sistemaOperativo', curso='$curso', horasEstudio=$horasEstudio)"
    }
}