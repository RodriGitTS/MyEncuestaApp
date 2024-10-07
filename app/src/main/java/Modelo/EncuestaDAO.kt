package Modelo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao

interface EncuestaDAO {
    @Insert
    suspend fun insertarEncuesta(encuesta: Encuesta)

    @Query("SELECT * FROM encuestas WHERE usuario= :usuario")
    suspend fun encuestaPorUsuario(usuario: String):Encuesta

    @Query("SELECT * FROM encuestas")
    suspend fun obtenerEncuestas(): List<Encuesta>
}