package Modelo

import androidx.room.Entity


abstract class Persona(open var dni:String,open var nombre:String,open var edad:Int){
    override fun toString(): String {
        return "Persona(dni='$dni', nombre='$nombre', edad=$edad)"
    }
}
