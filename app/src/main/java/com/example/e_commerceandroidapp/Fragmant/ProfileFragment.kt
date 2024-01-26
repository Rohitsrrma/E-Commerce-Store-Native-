package com.example.e_commerceandroidapp.Fragmant

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.e_commerceandroidapp.Activiity.OrderHistoryActivity
import com.example.e_commerceandroidapp.Activiity.UserProfileActivity
import com.example.e_commerceandroidapp.MyPreference
import com.example.e_commerceandroidapp.R


@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {

    var cont: Context? = null
    var profilename: TextView? = null
    var profileemail: TextView? = null
    var profilephone: TextView? = null
    var addressTV: TextView? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        cont = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val editTV = view.findViewById<TextView>(R.id.editTV)
        editTV.setOnClickListener {
            val intent = Intent(context, UserProfileActivity::class.java)
            startActivity(intent)
        }
        val orderHistoryLL = view.findViewById<LinearLayout>(R.id.orderhistoryLL)
        orderHistoryLL.setOnClickListener {
            val intent = Intent(context, OrderHistoryActivity::class.java)
            startActivity(intent)
        }

        val ratemeLL = view.findViewById<LinearLayout>(R.id.rateusLL)
        ratemeLL.setOnClickListener {
            rateApp()
        }

        val shareLL = view.findViewById<LinearLayout>(R.id.shareLL)
        shareLL.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(
                Intent.EXTRA_TEXT,
                "I Would like to share this E-Commerce Andriod App with you. Here You Can Download This Application from PlayStore" + "\n\nhttps://play.google.com/store/apps/details?id=com.solodroid.solomerce"
            )
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }
        val privacyLL = view.findViewById<LinearLayout>(R.id.privacyLL)
        privacyLL.setOnClickListener {
            val websiteUrl = "https://sites.google.com/view/ecommerce-privacy-policy"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
            startActivity(intent)
        }

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {

        profilename = view.findViewById(R.id.yournametextView)
        profileemail = view.findViewById(R.id.emailtextView)
        profilephone = view.findViewById(R.id.mobnoTV)
        addressTV = view.findViewById(R.id.addressTV)
    }

    override fun onResume() {


        super.onResume()

        val name = MyPreference.getData(cont, "Name")
        val email = MyPreference.getData(cont, "Email")
        val phone = MyPreference.getData(cont, "Phone Number")
        val address = MyPreference.getData(cont, "Address")

        if (name != profilename!!.text) {
            setProfileData()
        } else if (email != profileemail!!.text) {
            setProfileData()
        } else if (phone != profilephone!!.text) {
            setProfileData()
        } else if (address != addressTV!!.text) {
            setProfileData()
        } else {

        }


    }

    private fun setProfileData() {


        val name = MyPreference.getData(cont!!, "Name")
        val email = MyPreference.getData(cont!!, "Email")
        val phone = MyPreference.getData(cont!!, "Phone Number")
        val address = MyPreference.getData(cont!!, "Address")



        if (!name.isEmpty()) {
            profilename!!.text = name
        } else {
            profilename!!.text = "Your Name"
        }



        if (!email.isEmpty()) {
            profileemail!!.text = email
        } else {
            profileemail!!.text = "Your.email@xxx.com"
        }

        if (!phone.isEmpty()) {
            profilephone!!.text = phone

        } else {
            profilephone!!.text = "xxxxxxxxxx"
        }

        if (!address.isEmpty()) {
            addressTV!!.text = address
        } else {
            addressTV!!.text = "Your Address"

        }


    }


    fun rateApp() {
        try {
            val rateIntent = rateIntentForUrl("market://details")
            startActivity(rateIntent)
        } catch (e: ActivityNotFoundException) {
            val rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details")
            startActivity(rateIntent)
        }
    }

    private fun rateIntentForUrl(url: String): Intent {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(java.lang.String.format("%s?id=%s", url, "com.solodroid.solomerce"))
        )
        var flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        flags = if (Build.VERSION.SDK_INT >= 21) {

            flags or Intent.FLAG_ACTIVITY_NEW_DOCUMENT

        } else {

            flags or Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET

        }
        intent.addFlags(flags)

        return intent
    }


}



