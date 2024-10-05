package Modelo

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface UsuarioDAO {

    @Insert
    suspend fun insertarUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    suspend fun obtenerTodosUsuarios():List<Usuario>

    @Query("SELECT * FROM usuarios WHERE dni= :dni")
    suspend fun obtenerUsuarioPorDNI(dni:String): Usuario?

    @Query("DELETE FROM usuarios")
    suspend fun eliminarTodosLosUsuarios()

    @Query("DELETE FROM usuarios WHERE dni = :dni")
    suspend fun eliminarPersonaPorDNI(dni: String): Int

    @Update
    suspend fun actualizarPersona(persona: Persona):Int

}