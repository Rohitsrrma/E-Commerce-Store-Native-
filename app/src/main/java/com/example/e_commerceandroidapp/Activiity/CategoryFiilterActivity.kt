package com.example.e_commerceandroidapp.Activiity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceandroidapp.AdapterPackage.MyAdapterRecent
import com.example.e_commerceandroidapp.DataModel.CategoryData
import com.example.e_commerceandroidapp.DataModel.ProductModel
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData

class CategoryFiilterActivity : AppCompatActivity() {
    lateinit var adopter : MyAdapterRecent
    lateinit var rv : RecyclerView
    private var productList = mutableListOf<ProductModel>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_fiilter)



        rv = findViewById(R.id.Category_Filter_Recycler_View)
        val back_search_view = findViewById<ImageView>(R.id.Category_back_search)

        back_search_view.visibility = View.GONE

        val searchView = findViewById<SearchView>(R.id.Category_Filter_searchview)
        val closebutton = findViewById<ImageButton>(R.id.Category_Filter_close_button)
        closebutton.visibility = View.GONE
        val searchbutton = findViewById<ImageButton>(R.id.Category_Filter_search_button)
        val tbTV =  findViewById<TextView>(R.id.Category_Filter_tolbartitle)

        val categoryIntent = intent.getIntExtra("cateGory",0)
        val cateGoryName = intent.getStringExtra("cateGoryName")
        val Category_Filter_BackButton = findViewById<ImageView>(R.id.Category_Filter_BackButton)
        Category_Filter_BackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        tbTV.text= cateGoryName
        getProductList(categoryIntent)
        searchbutton.setOnClickListener {
            tbTV?.visibility = View.GONE
            searchView.setQueryHint(Html.fromHtml("<font color = #a9a9a9>" + getResources().getString(R.string.hintSearchMess) + "</font>"))
            back_search_view.visibility = View.GONE

            searchbutton.visibility = View.GONE
            searchView.visibility = View.VISIBLE
            searchView.setFocusable(true)
            searchView.requestFocusFromTouch()
            back_search_view.visibility = View.VISIBLE
            Category_Filter_BackButton.visibility = View.GONE


            val imm =  getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)

        }

        back_search_view.setOnClickListener {
            tbTV?.visibility = View.VISIBLE
            searchbutton.visibility = View.VISIBLE
            searchView.visibility = View.GONE
            back_search_view.visibility = View.GONE
            closebutton.visibility  = View.GONE
            back_search_view.visibility = View.GONE
            Category_Filter_BackButton.visibility = View.VISIBLE
        }

        closebutton.setOnClickListener {
            searchView.setQuery("",false)
            closebutton.visibility  = View.GONE


        }



        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (searchView.query.toString().isEmpty()){
                    closebutton.visibility  = View.GONE
                } else{
                    closebutton.visibility  = View.VISIBLE
                }

                adopter.getfilterList().filter(newText)

                return false
            }})
    }
    fun recyclerView(){

        adopter = MyAdapterRecent(this, productList)

        rv!!.adapter= adopter

        rv!!.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun getProductList(category : Int){
        productList.addAll(TestData.productList.filter {
            it.category == category
        })
        recyclerView()
    }
}
