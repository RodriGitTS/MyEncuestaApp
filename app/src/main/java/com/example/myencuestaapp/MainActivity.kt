package com.example.myencuestaapp

import Parametros.Parametros
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.myencuestaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivityMainBinding.inflate(layoutInflater)
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
            AppDatabase::class.java,Parametros.nombre_BD
        ).build()




        binding.btnLogin.setOnClickListener {


            //Si es administrador se abre ventana de admin (dni=admin)
            //Si es usuario se abre ventana de usuario (nombre contraseña en la bd)

            //Si no consta, se invitara a registrarse (datos no validos)

        }
        binding.txtRegistro.setOnClickListener{



        }


    }
}