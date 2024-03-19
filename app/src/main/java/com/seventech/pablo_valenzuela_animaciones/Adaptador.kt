package com.seventech.pablo_valenzuela_animaciones

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

public class Adaptador
    (var contexto: Context, var datos:Array<Array<String>>, var datosImg:IntArray):
    BaseAdapter(){
        init{
            inflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista = inflater!!.inflate(R.layout.profile_list, null)
        val name = vista.findViewById<View>(R.id.tvNameProfile) as TextView
        val section = vista.findViewById<View>(R.id.tvNameSection) as TextView
        val image = vista.findViewById<View>(R.id.ivImageProfile) as ImageView

        name.text = datos[position][0]
        section.text = datos[position][1]
        image.setImageResource(datosImg[position])
        image.tag = position

        val mediaPlayer = MediaPlayer.create(contexto, R.raw.click)

        image.setOnClickListener {v ->
            val captureImagen = Intent(contexto, capture_image::class.java)
            captureImagen.putExtra("IMG", datosImg[(v.tag as Int)])
            mediaPlayer.start()
            contexto.startActivity(captureImagen)
        }

        return vista
    }

    override fun getCount(): Int {
        return datosImg.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    companion object{
        private var inflater:LayoutInflater? = null
    }

}
