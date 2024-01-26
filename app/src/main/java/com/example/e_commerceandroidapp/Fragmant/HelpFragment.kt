package com.example.e_commerceandroidapp.Fragmant

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.e_commerceandroidapp.Activiity.*

import com.example.e_commerceandroidapp.R



class HelpFragment : Fragment() {




    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_help, container, false)

        val howtoOrder = view.findViewById<LinearLayout>(R.id.howToOrderLL)
        val payment =   view.findViewById<LinearLayout>(R.id.paymentLL)
        val shipping =  view.findViewById<LinearLayout>(R.id.shippingLL)
        val profile =   view.findViewById<LinearLayout>(R.id.profileLL)
        val contactUs = view.findViewById<LinearLayout>(R.id.contactUsLL)

        howtoOrder.setOnClickListener {
            val intent = Intent(context,HowToOrderActivity::class.java)
            startActivity(intent)
        }
        payment.setOnClickListener {
            val intent = Intent(context, PaymentActivity::class.java)
            startActivity(intent)
        }
        shipping.setOnClickListener {
            val intent = Intent(context, ShippingActivity::class.java)
            startActivity(intent)
        }
        profile.setOnClickListener {

            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }
        contactUs.setOnClickListener {
            val intent = Intent(context,ContactUsActivity::class.java)
            startActivity(intent)
        }
        return view

    }
}
