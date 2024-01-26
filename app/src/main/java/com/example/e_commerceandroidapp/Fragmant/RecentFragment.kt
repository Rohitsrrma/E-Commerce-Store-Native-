package com.example.e_commerceandroidapp.Fragmant

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceandroidapp.AdapterPackage.MyAdapterRecent
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData

class RecentFragment : Fragment() {
    lateinit var adopter: MyAdapterRecent
    private lateinit var fContext: Context



    var rv: RecyclerView?=null




    override fun onCreate(savedInstanceState: Bundle?) {

        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.fragment_recent, container, false)
        rv = v.rootView.findViewById(R.id.rvrecent)
        //    val searchQuery = arguments?.getString("search_query")
        val back_search_view = (fContext as Activity).findViewById<ImageView>(R.id.back_search_view)
        back_search_view.visibility = View.GONE

        val searchView = (fContext as Activity).findViewById<SearchView>(R.id.search_view)
        val closebutton = (fContext as Activity).findViewById<ImageButton>(R.id.closebutton)
        closebutton.visibility = View.GONE
        val searchbutton = (fContext as Activity).findViewById<ImageButton>(R.id.searchbutton)
        val tbTV =  (fContext as Activity).findViewById<TextView>(R.id.tbTitle)
        searchbutton.setOnClickListener {
            tbTV?.visibility = View.GONE
            searchView.setQueryHint(Html.fromHtml("<font color = #a9a9a9>" + getResources().getString(R.string.hintSearchMess) + "</font>"))


            searchbutton.visibility = View.GONE
            searchView.visibility = View.VISIBLE
            searchView.setFocusable(true)
            searchView.requestFocusFromTouch()
            back_search_view.visibility = View.VISIBLE

            val imm =  (fContext as Activity).getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        back_search_view.setOnClickListener {
            tbTV?.visibility = View.VISIBLE
            searchbutton.visibility = View.VISIBLE
            searchView.visibility = View.GONE
            back_search_view.visibility = View.GONE
            closebutton.visibility  = View.GONE
            recyclerView()
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


        return v.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun recyclerView() {
        adopter = MyAdapterRecent(fContext,TestData.productList)
        rv!!.adapter= adopter
        rv!!.layoutManager = GridLayoutManager(fContext, 2, GridLayoutManager.VERTICAL, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext=context
    }




}






