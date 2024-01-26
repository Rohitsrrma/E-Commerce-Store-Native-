package com.example.e_commerceandroidapp.Activiity

import android.app.Dialog
import android.os.Bundle
import android.text.InputType
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerceandroidapp.MyPreference
import com.example.e_commerceandroidapp.MyPreference.Companion.getData
import com.example.e_commerceandroidapp.R
import java.util.regex.Pattern


class UserProfileActivity : AppCompatActivity() {

    lateinit var linearLayoutNameTextView: LinearLayout
    lateinit var linearLayoutEmailTextView : LinearLayout
    lateinit var linearLayoutPhoneNoTextView : LinearLayout
    lateinit var linearLayoutAddressTextView : LinearLayout
    lateinit var backbuttonUserProfile : ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        initViews()
       initListeners()

        val name=getData(this,"Name")
        val email=getData(this,"Email")
        val phone=getData(this,"Phone Number")
        val address=getData(this,"Address")


        var nameEntry = findViewById<TextView>(R.id.yournameprofile)
        var emailEntry = findViewById<TextView>(R.id.youremailprofile)
        var phoneNoEntry = findViewById<TextView>(R.id.yourPhoneNoprofile)
        var addressEntry = findViewById<TextView>(R.id.yourAddressprofile)

        nameEntry.text=name
        emailEntry.text=email
        phoneNoEntry.text=phone
        addressEntry.text=address

    }

    fun initViews() {
        linearLayoutNameTextView = findViewById(R.id.linearLayoutName)
        linearLayoutEmailTextView = findViewById(R.id.linearLayoutEmail)
        linearLayoutPhoneNoTextView = findViewById(R.id.linearLayoutPhoneNo)
        linearLayoutAddressTextView = findViewById(R.id.linearLayoutAddress)
        backbuttonUserProfile = findViewById(R.id.backUserProfiile)
    }

        fun initListeners() {
            linearLayoutNameTextView.setOnClickListener {
                editNameDialog("Name")
            }
            linearLayoutEmailTextView.setOnClickListener {
                editNameDialog("Email")
            }
            linearLayoutPhoneNoTextView.setOnClickListener {
                editNameDialog("Phone Number")
            }
            linearLayoutAddressTextView.setOnClickListener {
                editNameDialog("Address")
            }
            backbuttonUserProfile.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }


    fun editNameDialog(hinttext : String) {

        val dialog = Dialog(this) // Replace `context` with the appropriate context object
        dialog.setContentView(R.layout.dialog_layout) // Replace `dialog_layout` with the appropriate layout file
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val et = dialog.findViewById<EditText>(R.id.editText)
        et.setHint(hinttext)

        val titlename = dialog.findViewById<TextView>(R.id.titleName)
        titlename.text = hinttext
        val okButton = dialog.findViewById<Button>(R.id.ok)
        val cancel = dialog.findViewById<Button>(R.id.cancelbutton)

        var nameEntry    =    findViewById<TextView>(R.id.yournameprofile)
        var emailEntry   =    findViewById<TextView>(R.id.youremailprofile)
        var phoneNoEntry =    findViewById<TextView>(R.id.yourPhoneNoprofile)
        var addressEntry =    findViewById<TextView>(R.id.yourAddressprofile)


        cancel.setOnClickListener {
            dialog.dismiss()
        }

        var edittextentry = titlename.text.toString()
        when(edittextentry){

            "Name" -> {

                et.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            }
            "Email" -> {
                et.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

            }
            "Phone Number" -> {
                et.inputType = InputType.TYPE_CLASS_PHONE

            }
            "Address" -> {
                et.inputType = InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS}
        }


        okButton.setOnClickListener {

            val etText=et.text.toString()

            var edittextentry = titlename.text.toString()
            // Handle the click event of the Done button
            when(edittextentry){

                "Name" -> {
                    nameEntry.text = etText
                    dialog.dismiss()

                }
                "Email" -> {
                    if(isValidEmailId(etText)){
                        emailEntry.text = etText
                        dialog.dismiss()
                    } else {
                        et.error="Enter Email In Correct Format"
                    }
                }
                "Phone Number" -> {
                        if (etText.length==10){
                            phoneNoEntry.text = etText
                            dialog.dismiss()
                        }else{
                            et.error="Enter 10 Digit Number"
                        }
                }
                "Address" -> {
                    addressEntry.text = etText
                    dialog.dismiss()
                }
            }


            MyPreference.saveData(this@UserProfileActivity,edittextentry,etText)

            // Do something with the entered text
        }

        dialog.show() // Show the dialog
    }

    private fun isValidEmailId(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }



}




