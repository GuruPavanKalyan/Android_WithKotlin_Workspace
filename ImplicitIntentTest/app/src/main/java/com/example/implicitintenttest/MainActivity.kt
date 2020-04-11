package com.example.implicitintenttest

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openProfile(view: View) {
        val i = Intent()
        i.setAction(ACTION_VIEW)
        i.setData(Uri.parse("https://www.mastan511.github.io/"))
        startActivity(i)

    }
    fun openCamera(view: View) {
        val  i = Intent()
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,22)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 22){
            if(resultCode == Activity.RESULT_OK && data != null){
                val img = data.getParcelableExtra<Bitmap>("data")
                val iv = findViewById<ImageView>(R.id.imageview)
                iv.setImageBitmap(img)
            }
        }
    }
}
