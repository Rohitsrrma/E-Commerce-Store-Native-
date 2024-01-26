package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceandroidapp.AdapterPackage.OrderHistoryAdapter
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData

class OrderHistoryActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)
        val deleteOrderHistoryImageView = findViewById<ImageView>(R.id.deleteOrderHistoryImageView)
        val rv = findViewById<RecyclerView>(R.id.rv_orderhistry)
        val Not_Ordered_Yet = findViewById<LinearLayout>(R.id.Not_Ordered_Yet)
        deleteOrderHistoryImageView.setOnClickListener {
            if(TestData.orderHistory.isEmpty()){
                Not_Ordered_Yet.visibility = View.VISIBLE
                Toast.makeText(this,"Your Order List is Empty", Toast.LENGTH_SHORT).show()
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
                    TestData.orderHistory.clear()
                    Toast.makeText(this,"Your Ordered Items are Cleared", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    recyclerView()


                }
                val noBtn = dialog.findViewById<Button>(R.id.no_button)

                noBtn.setOnClickListener {

                    dialog.dismiss()

                }
            }

        }

        val backbuttonOrderHistory = findViewById<ImageView>(R.id.backUserProfiile)
        backbuttonOrderHistory.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }


        if(TestData.orderHistory.isEmpty()){

            Not_Ordered_Yet.visibility = View.VISIBLE
            rv.visibility= View.GONE

        }else{
            Not_Ordered_Yet.visibility = View.GONE
            recyclerView()
        }
    }
    private fun recyclerView() {
        val rv = findViewById<RecyclerView>(R.id.rv_orderhistry)
        val orderHistoryAdapter = OrderHistoryAdapter(TestData.orderHistory, this)
        rv!!.adapter = orderHistoryAdapter
        rv!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}