package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.e_commerceandroidapp.R

class ShippingActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)
        val backbtn = findViewById<ImageView>(R.id.backbuttonShipping)
        backbtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}