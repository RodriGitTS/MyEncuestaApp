package com.example.myencuestaapp

import Modelo.Persona
import Modelo.Usuario
import Parametros.Parametros
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myencuestaapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

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

            var user:Usuario?=null
            var dni=binding.lblUsuario.text.toString()
            var pass=binding.lblUsuario.text.toString()
        lifecycleScope.launch {
            try {
                user=database.usuarioDAO().obtenerUsuarioPorDNI(dni)
            }catch(E:Exception){}

            if (user!=null){
                if (user!!.dni=="admin" && user!!.password==pass){

                    Toast.makeText(this@MainActivity,"Datos de admin correctos",Toast.LENGTH_SHORT).show()
                    //ENTRAR EN LA APLICACION COMO ADMIN

                }else if (user!!.dni==dni && user!!.password==pass){

                    Toast.makeText(this@MainActivity,"Datos usuario correctos",Toast.LENGTH_SHORT).show()

                }else Toast.makeText(this@MainActivity,"Datos incorrectos",Toast.LENGTH_SHORT)
            }

        }

        }
        binding.txtRegistro.setOnClickListener{

            var intent=Intent(this,VentanaRegistro::class.java)
            startActivity(intent)
        }


    }
}