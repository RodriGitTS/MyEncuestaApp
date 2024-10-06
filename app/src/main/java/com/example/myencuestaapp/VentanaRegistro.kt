package com.example.myencuestaapp

import Modelo.Usuario
import Parametros.Parametros
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myencuestaapp.databinding.ActivityVentanaRegistroBinding
import kotlinx.coroutines.launch

class VentanaRegistro : AppCompatActivity() {
    lateinit var binding: ActivityVentanaRegistroBinding
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityVentanaRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database= Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, Parametros.nombre_BD
        ).build()





        binding.btnRegistrar.setOnClickListener {

            if (binding.lblDNI.text!!.isNotEmpty() &&
                binding.lblEdad.text.isNotEmpty() &&
                binding.lblPass.text.isNotEmpty()
                ){

                lifecycleScope.launch {
                    try {


                        val Usuario=Usuario(dni = binding.lblDNI.text.toString(),
                            edad = binding.lblEdad.text.toString().toInt(),
                            password = binding.lblPass.text.toString(),
                            nombre = binding.lblNombre2.text.toString())


                        database.usuarioDAO().insertarUsuario(Usuario)
                        Toast.makeText(this@VentanaRegistro,"Persona añadida",Toast.LENGTH_SHORT).show()
                    }catch (E:Exception){
                       Toast.makeText(this@VentanaRegistro,"DNI duplicado. No se pudo registrar",Toast.LENGTH_SHORT).show()
                    }
                }
                binding.btnVolver.setOnClickListener {
                    finish()
                }

            }

        }
    }
}