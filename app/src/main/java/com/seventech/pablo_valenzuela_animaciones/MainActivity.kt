package com.seventech.pablo_valenzuela_animaciones

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ivAnimation: ImageView
    private lateinit var ivButtomProfile: ImageView
    private lateinit var shoppyMiauAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
        initComponent()
        initListeners()
        initUi()
    }

    private fun initComponent() {
        ivAnimation = findViewById(R.id.ivAnimation)
        ivButtomProfile = findViewById(R.id.ivButtomProfile)
    }



    private fun initListeners() {
        /*ivAnimation.setOnClickListener { shoppyMiauAnimation.start() }*/

        val mediaPlayer = MediaPlayer.create(this, R.raw.click)

        ivButtomProfile.setOnClickListener {
            val intent = Intent(this, Profiles::class.java)
            mediaPlayer.start()
            startActivity(intent)
        }

    }

    private fun initUi() {
        ivAnimation.apply {
            setBackgroundResource(R.drawable.shopy_miau_animation)
            shoppyMiauAnimation = background as AnimationDrawable
            shoppyMiauAnimation.start() //Si quiero que la aplicacion se inicie al dar click borro esta linea y descomento lo que tengo comentado en el initListeners
        }
    }

}