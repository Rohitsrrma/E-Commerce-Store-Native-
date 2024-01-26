package com.example.e_commerceandroidapp.Activiity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.e_commerceandroidapp.R


class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val backbutton = findViewById<ImageView>(R.id.backUserPay)
        backbutton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}