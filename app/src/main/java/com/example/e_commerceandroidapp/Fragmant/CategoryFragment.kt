package com.example.e_commerceandroidapp.Fragmant

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceandroidapp.AdapterPackage.MyAdapterCategory
import com.example.e_commerceandroidapp.DataModel.CategoryData
import com.example.e_commerceandroidapp.DataModel.ProductModel
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData

class CategoryFragment : Fragment() {

    private lateinit var ctx : Context
    private lateinit var adopter : MyAdapterCategory
    var rv: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_category, container,false)
        rv= view.rootView.findViewById(R.id.rvcategory)
        return view.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val back_search_view = (ctx as Activity).findViewById<ImageView>(R.id.back_search_view)
        back_search_view.visibility = View.GONE

        val searchView = (ctx as Activity).findViewById<SearchView>(R.id.search_view)
        val closebutton = (ctx as Activity).findViewById<ImageButton>(R.id.closebutton)
        closebutton.visibility = View.GONE
        val searchbutton = (ctx as Activity).findViewById<ImageButton>(R.id.searchbutton)
        val tbTV =  (ctx as Activity).findViewById<TextView>(R.id.tbTitle)
        searchbutton.setOnClickListener {
            tbTV?.visibility = View.GONE
            searchView.setQueryHint(Html.fromHtml("<font color = #a9a9a9>" + getResources().getString(R.string.hintSearchMess) + "</font>"))


            searchbutton.visibility = View.GONE
            searchView.visibility = View.VISIBLE
            searchView.setFocusable(true)
            searchView.requestFocusFromTouch()
            back_search_view.visibility = View.VISIBLE

            val imm =  (ctx as Activity).getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        back_search_view.setOnClickListener {
            tbTV?.visibility = View.VISIBLE
            searchbutton.visibility = View.VISIBLE
            searchView.visibility = View.GONE
            back_search_view.visibility = View.GONE
            closebutton.visibility  = View.GONE
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
        recyclerView()
    }

    private fun recyclerView() {




       adopter = MyAdapterCategory(ctx,TestData.categoryList)
        rv!!.adapter = adopter
        rv!!.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx=context
    }


}