package com.seventech.pablo_valenzuela_animaciones

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class capture_image : AppCompatActivity() {

    private lateinit var ivButtomHome: ImageView
    private lateinit var ivButtomProfile: ImageView
    private lateinit var btnCapture: Button
    private lateinit var ivCaptureImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_image)
        initComponents()
        initListeners()
    }


    private fun initComponents() {
        ivButtomHome = findViewById(R.id.ivButtomHome)
        ivButtomProfile = findViewById(R.id.ivButtomProfile)
        btnCapture = findViewById(R.id.btnCapture)
        ivCaptureImage = findViewById(R.id.ivCaptureImage)
    }

    private fun initListeners() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.click)

        ivButtomHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            mediaPlayer.start()
            startActivity(intent)
        }

        ivButtomProfile.setOnClickListener {
            val intent = Intent(this, Profiles::class.java)
            mediaPlayer.start()
            startActivity(intent)
        }

        btnCapture.setOnClickListener {
            mediaPlayer.start()

            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startForResult.launch(cameraIntent)
        }
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data: Intent? = result.data
            val imageBitmap = data?.extras?.get("data") as Bitmap?
            ivCaptureImage.setImageBitmap(imageBitmap)
        }

    }

}