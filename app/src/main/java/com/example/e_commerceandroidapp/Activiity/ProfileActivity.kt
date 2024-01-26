package com.example.e_commerceandroidapp.Activiity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.e_commerceandroidapp.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val backbtn = findViewById<ImageView>(R.id.backprofile)
        backbtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}