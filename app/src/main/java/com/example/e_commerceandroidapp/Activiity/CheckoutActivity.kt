package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerceandroidapp.DataModel.OrderHistoryModel
import com.example.e_commerceandroidapp.MyPreference
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern


class CheckoutActivity : AppCompatActivity() {
    lateinit var alldetailtext : String
    val list = arrayOf("TNT Express","DHL Express","FedEx","UPS","COD(Cash On Delivery")

    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var adapterItems : ArrayAdapter<String>

    lateinit var checkout_Name: TextInputEditText
    lateinit var checkout_Email: TextInputEditText
    lateinit var checkout_Phone: TextInputEditText
    lateinit var checkout_Address: TextInputEditText
    lateinit var checkout_Comment: TextInputEditText
    lateinit var process_checkout_Linear_Layout :  LinearLayout
    lateinit var no_button_Process_Checkout : Button
    lateinit var yes_button_Process_Checkout : Button
    lateinit var checkout_Order_Detail: TextInputEditText



    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {






        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        autoCompleteTextView = findViewById(R.id.auto_complete_text)

        adapterItems =ArrayAdapter<String>(this,R.layout.list_items_checkout,list)
        autoCompleteTextView.setAdapter(adapterItems)



        autoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = list[position]

            }


        initViews()
        orderDetailText()



        val backUserCheckout = findViewById<ImageView>(R.id.backUserCheckout)
        backUserCheckout.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        process_checkout_Linear_Layout.setOnClickListener {
            val dialog = Dialog(this)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setContentView(R.layout.process_checkout_dialog)
            dialog.show()
            no_button_Process_Checkout = dialog.findViewById(R.id.no_button_Process_Checkout)
            yes_button_Process_Checkout = dialog.findViewById(R.id.yes_button_Process_Checkout)

            no_button_Process_Checkout.setOnClickListener {
                dialog.dismiss()
            }
            yes_button_Process_Checkout.setOnClickListener {

               val submitorderdialog = Dialog(this)
                submitorderdialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                submitorderdialog.setContentView(R.layout.submit_order_dialog)
                submitorderdialog.show()
                val handler=android.os.Handler(Looper.getMainLooper())
                handler.postDelayed(object:Runnable{
                    override fun run() {
                        submitorderdialog.dismiss()
                        dialog.dismiss()
                        orderconfirmed()


                    } },2000)
                val purchasecode = randomStringGen()
                val totalpricewithtax = orderDetailText()
                val currentDate = Date()
                val dateFormat = SimpleDateFormat("dd-MMMM-yyyy")
                val localDate = dateFormat.format(currentDate)
                val localTime = LocalTime.now()
                val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
                val formattedTime = localTime.format(formatter)



               TestData.orderHistory.add(OrderHistoryModel(alldetailtext,purchasecode,localDate,formattedTime,totalpricewithtax))


                TestData.cartProductList.clear()



            }

        }











        }





    fun orderconfirmed(){
        val OrderConfirmationDialog = Dialog(this@CheckoutActivity)
        OrderConfirmationDialog.setContentView(R.layout.order_confirmation_dialog)
        OrderConfirmationDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        OrderConfirmationDialog.show()
        val OK_button_Order_confirmation = OrderConfirmationDialog.findViewById<Button>(R.id.OK_button_Order_confirmation)


        OK_button_Order_confirmation.setOnClickListener {
            OrderConfirmationDialog.dismiss()
            val openIntent = Intent(this, MainActivity::class.java)
            openIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext.startActivity(openIntent)

        }
    }

    fun initViews(){
        checkout_Name = findViewById(R.id.checkout_Name)
        checkout_Email = findViewById(R.id.checkout_Email)
        checkout_Phone = findViewById(R.id.checkout_Phone)
        checkout_Address = findViewById(R.id.checkout_Address)
        checkout_Comment = findViewById(R.id.checkout_Comment)
        process_checkout_Linear_Layout = findViewById(R.id.process_checkout_Linear_Layout)
        checkout_Order_Detail = findViewById(R.id.checkout_Order_Detail)



        if(!MyPreference.getData(this,"Name").isEmpty()){
            checkout_Name.setText(MyPreference.getData(this,"Name"))
        }
        if (!MyPreference.getData(this,"Email").isEmpty()){
            checkout_Email.setText(MyPreference.getData(this,"Email"))
        }
        if(!MyPreference.getData(this,"Phone Number").isEmpty()){
            checkout_Phone.setText(MyPreference.getData(this,"Phone Number"))
        }
        if(!MyPreference.getData(this,"Address").isEmpty()){
            checkout_Address.setText(MyPreference.getData(this,"Address"))
        }
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

    fun orderDetailText(): Double {
        val df = DecimalFormat("#.##")
        var orderDetailText = ""
        var pricetotal = 0.0
        var taxprice = 0.0
        var totalpricewithtax =0.0
        for(i in TestData.cartProductList){
            pricetotal += i.productModel.price*i.quantity
            taxprice= pricetotal * 0.1
            totalpricewithtax=pricetotal+taxprice

            val totalprice = df.format(i.productModel.price * i.quantity)

            orderDetailText += i.quantity.toString() + ". " + i.productModel.name + " " + totalprice.toString()+" USD" + "\n"

        }

        val roundedNumbertax = df.format(taxprice).toDouble()
        val roundedNumberorder = df.format(pricetotal).toDouble()
        val roundedNumberTotal = df.format(totalpricewithtax).toDouble()
        alldetailtext = orderDetailText+"\n\nOrder : "+roundedNumberorder+" USD\n"+"Tax : 10% : "+roundedNumbertax +" USD\n"+"Total : "+roundedNumberTotal+" USD\n\n"
        checkout_Order_Detail.setText(alldetailtext)


        return totalpricewithtax
    }

    fun randomStringGen(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = java.util.Random()
        val sb = StringBuilder()

        for (i in 0 until 10) {
            sb.append(chars[random.nextInt(chars.length)])
        }

        val randomString = sb.toString()
        return randomString
    }




}