package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.e_commerceandroidapp.R

class ContactUsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        val backbtn = findViewById<ImageView>(R.id.backcontact)
        backbtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }



    }
}