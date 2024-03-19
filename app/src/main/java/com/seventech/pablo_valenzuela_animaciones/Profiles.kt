package com.seventech.pablo_valenzuela_animaciones

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Profiles : AppCompatActivity() {

    var Lista: ListView? = null
    var datos = arrayOf(
        arrayOf("Maria Gonzalez", "Deparatamento de Zapateria"),
        arrayOf("Jose Flores", "Departamente de Bebe"),
        arrayOf("Luis Rojas", "Departamento de Deportes"),
        arrayOf("Juan Diaz", "Departamento de Lenceria"),
        arrayOf("Carlos Perez", "Depatamento de Vesturio femenino")
    )

    var datosImg = intArrayOf(R.drawable.perfil1, R.drawable.perfil2, R.drawable.perfil3, R.drawable.perfil4, R.drawable.perfil5)

    private lateinit var lvProfiles: ListView
    private lateinit var ivButtomHome: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles)
        initComponents()
        initListeners()
        initUi()
    }

    private fun initComponents() {
        lvProfiles = findViewById(R.id.lvProfiles)
        ivButtomHome = findViewById(R.id.ivButtomHome)
    }

    private fun initListeners() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.click)

        ivButtomHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            mediaPlayer.start()
            startActivity(intent)
        }
    }

    private fun initUi() {
        Lista = findViewById<View>(R.id.lvProfiles) as ListView
        Lista!!.adapter = Adaptador(this, datos, datosImg)
    }
}