package Modelo

class Usuario(dni:String, nombre: String, edad: Int, var password: String
): Persona(dni, nombre, edad)
