package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceandroidapp.AdapterPackage.MyAdapterShoppingCart

import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData


class ShoppingCartActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        recyclerView()
        itemPriceWithTax()


        val contimueshoping = findViewById<TextView>(R.id.continueshop)
        contimueshoping.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val checkout_lienar_layout = findViewById<LinearLayout>(R.id.bottom_bar_checkout)
        val empty_Cart_View = findViewById<LinearLayout>(R.id.empty_Cart_View)
        val deleteShoppingCartImageView = findViewById<ImageView>(R.id.deleteShoppingCartImageView)
        deleteShoppingCartImageView.setOnClickListener {
            if(TestData.cartProductList.isEmpty()){


                Toast.makeText(this,"Your Cart is Empty",Toast.LENGTH_SHORT).show()
            } else{
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.delete_dialog)
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                dialog.show()

                val yesBtn = dialog.findViewById<Button>(R.id.yes_button)
                yesBtn.setOnClickListener {
                    TestData.cartProductList.clear()
                    empty_Cart_View.visibility = View.VISIBLE
                    checkout_lienar_layout.visibility = View.GONE

                    Toast.makeText(this,"Your Cart Items are Cleared",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    recyclerView()

                }
                val noBtn = dialog.findViewById<Button>(R.id.no_button)
                noBtn.setOnClickListener {
                    dialog.dismiss()
                }
            }
        }
        val back = findViewById<ImageView>(R.id.backUserShopping)
        back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val checkout_btn = findViewById<LinearLayout>(R.id.checkout_Linear_Layout)
        checkout_btn.setOnClickListener {
            val intent = Intent(this,CheckoutActivity::class.java)
            startActivity(intent)
        }

        if (TestData.cartProductList.isEmpty()){
            empty_Cart_View.visibility = LinearLayout.VISIBLE
            checkout_lienar_layout.visibility = LinearLayout.GONE
        }  else {
            empty_Cart_View.visibility = LinearLayout.GONE
            itemPriceWithTax()
        }
    }

    private fun recyclerView() {
        val rv = findViewById<RecyclerView>(R.id.RV_shopping_cart)
        if(TestData.cartProductList.isEmpty()){
            rv.visibility=View.GONE
        } else{
            rv.visibility=View.VISIBLE

        }

        val shoppingCartAdapter = MyAdapterShoppingCart(TestData.cartProductList, this)
        rv!!.adapter = shoppingCartAdapter
        rv!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

   private fun itemPriceWithTax(){
       val checkout_after_tax_text_view = findViewById<TextView>(R.id.checkout_after_tax_text_view)
       var roundedNumber = 0.0
       for (i in TestData.cartProductList) {
           var totalPrice = 0.0
           var price = i.productModel.price
           var quantity = i.quantity
           val totalpriceofitem = price * quantity
           val list = ArrayList<Double>()
           list.add(totalpriceofitem)
           val pricewithtax = (list.sum() * 0.1) + list.sum()
           totalPrice = (totalPrice + pricewithtax)
           roundedNumber = String.format("%.2f",totalPrice).toDouble()
       }
       checkout_after_tax_text_view.text =  "Total : "+ roundedNumber +" USD"
   }
}