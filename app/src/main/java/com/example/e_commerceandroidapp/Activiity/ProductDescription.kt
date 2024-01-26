package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.e_commerceandroidapp.DataModel.CartProductModel
import com.example.e_commerceandroidapp.DataModel.ProductModel


import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso


@Suppress("DEPRECATION")
class ProductDescription : AppCompatActivity() {
   private var productModel : ProductModel?=null
    lateinit var item_Count_prod_desc: TextView




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
         productModel = intent.getSerializableExtra("productModel") as ProductModel?

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_description)


        val backbutton = findViewById<ImageView>(R.id.backprofileproddesc)
        backbutton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }



        val shareproddesc = findViewById<LinearLayout>(R.id.shareproddesc)

        shareproddesc.setOnClickListener {

        }


        item_Count_prod_desc = findViewById(R.id.item_Count_prod_desc)


        val BottomNavProdDesc = findViewById<BottomNavigationView>(R.id.BottomNavProdDesc)
        BottomNavProdDesc.setOnClickListener {

            addToCartDialog()


        }



        val cartproddesc = findViewById<LinearLayout>(R.id.cartproddesc)
        cartproddesc.setOnClickListener {

            val intent = Intent(this, ShoppingCartActivity::class.java)
            //  intent.putExtra("itemCount",itemcountshare())
            intent.putExtra("productModel",productModel)
            startActivity(intent)

        }


        val productname = findViewById<TextView>(R.id.productname)
        val pricepd = findViewById<TextView>(R.id.pricepd)
        val imagepd = findViewById<ImageView>(R.id.imagepd)
        productname.text = productModel!!.name
        pricepd.text = productModel!!.price.toString()
        Picasso.get().load(productModel!!.thumb).into(imagepd)


        val ProdDescTV = findViewById<View>(R.id.textViewProddesc)

        val barLayout = findViewById<AppBarLayout>(R.id.AppBarLayour)
        var scrollRange = -1

        val share_prodDesc = findViewById<ImageView>(R.id.share_prodDesc)
        val cart_prod_desc = findViewById<ImageView>(R.id.cart_prod_desc)
        barLayout.addOnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }

            val scroll = scrollRange + verticalOffset
            Log.d("sd", "onOffsetChanged: " + scroll)

            if (scroll == 0) {
                ProdDescTV.visibility = View.VISIBLE
               backbutton.setColorFilter(ContextCompat.getColor(this,R.color.white), PorterDuff.Mode.SRC_IN)

                share_prodDesc.setColorFilter(ContextCompat.getColor(this,R.color.white), PorterDuff.Mode.SRC_IN)
                cart_prod_desc.setColorFilter(ContextCompat.getColor(this,R.color.white), PorterDuff.Mode.SRC_IN)

                //isShow = true
            } else {
                ProdDescTV.visibility = View.GONE
               backbutton.setColorFilter(ContextCompat.getColor(this,R.color.ColorForWhiteBG), PorterDuff.Mode.SRC_IN)
                share_prodDesc.setColorFilter(ContextCompat.getColor(this,R.color.ColorForWhiteBG), PorterDuff.Mode.SRC_IN)
                cart_prod_desc.setColorFilter(ContextCompat.getColor(this,R.color.ColorForWhiteBG), PorterDuff.Mode.SRC_IN)
            }
        }

// Set the visibility to gone when entering collapse mode

    }


    fun addToCartDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.addtocartdialog)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val canceladdtocart = dialog.findViewById<Button>(R.id.canceladdtocart)
        val okaddtocart = dialog.findViewById<Button>(R.id.okaddtocart)
        val editTextaddtocart = dialog.findViewById<EditText>(R.id.editTextaddtocart)
        val toastBlank = Toast.makeText(this, "Order can not be blank", Toast.LENGTH_SHORT)
        val toastZero = Toast.makeText(this, "Order can not be Zero", Toast.LENGTH_SHORT)
        val toastItemAdded =
            Toast.makeText(this, "Success Product added to Cart", Toast.LENGTH_SHORT)
        val toastItemOver = Toast.makeText(this, "Stock is not Enough", Toast.LENGTH_SHORT)

        okaddtocart.setOnClickListener {

            val et = editTextaddtocart.text.toString()

            val position = intent.getIntExtra("position",0)
            if (et.isNullOrEmpty()){
                dialog.dismiss()
                toastBlank.setGravity(Gravity.CENTER, 0, 0)
                toastBlank.show()
            }else{
                TestData.cartProductList.add(CartProductModel(ProductModel(productModel!!.name,productModel!!.price,productModel!!.thumb),et.toInt()),)
                val itemcountnum = 5

                var num = et.toInt()
                if (num == 0) {
                    dialog.dismiss()
                    toastZero.show()
                    toastZero.setGravity(Gravity.BOTTOM, 0, 0)
                } else if (num!! > itemcountnum) {
                    dialog.dismiss()
                    toastItemOver.setGravity(Gravity.TOP, 0, 0)
                    toastItemOver.show()
                } else {
                    dialog.dismiss()
                    toastItemAdded.setGravity(Gravity.RIGHT, 0, 0)
                    toastItemAdded.show()
                }

            }




            //val itemcountet = item_Count_prod_desc.text.toString()
            //val itemcountnum = itemcountet.toInt()
        }

        canceladdtocart.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()


    }






}