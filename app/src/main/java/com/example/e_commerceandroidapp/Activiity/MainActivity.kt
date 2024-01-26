package com.example.e_commerceandroidapp.Activiity



import android.content.Intent

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e_commerceandroidapp.Fragmant.CategoryFragment
import com.example.e_commerceandroidapp.Fragmant.HelpFragment
import com.example.e_commerceandroidapp.Fragmant.ProfileFragment
import com.example.e_commerceandroidapp.Fragmant.RecentFragment
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.databinding.ActivityMainBinding

import com.example.e_commerceandroidapp.datasource.TestData



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {

        TestData.productList.clear()

        TestData.addtotestproduct()

        TestData.categoryList.clear()

        TestData.addtoCategoryList()

        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(RecentFragment(),"E-Commerce Android App")

        val shoppingcartMainAct = findViewById<LinearLayout>(R.id.shoppingcartMainAct)

        shoppingcartMainAct.setOnClickListener {
                val intent = Intent(this,ShoppingCartActivity::class.java)
                startActivity(intent)
        }


        binding.bottomNavigationView.setOnItemSelectedListener {
            val search = binding.searchbutton
            val tbTitle = binding.tbTitle
            val searchView = binding.searchView

            when(it.itemId){
                R.id.recent -> replaceFragment(RecentFragment(),"E-Commerce Android App").apply {

                    tbTitle.visibility= View.VISIBLE
                    search.visibility = View.VISIBLE
                    searchView.visibility = View.GONE
                }
                R.id.category -> replaceFragment(CategoryFragment(),"Category").apply {
                    tbTitle.visibility= View.VISIBLE
                    search.visibility = View.VISIBLE
                    searchView.visibility = View.GONE

                }
                R.id.help -> replaceFragment(HelpFragment(),"Help").apply {
                    searchView.visibility = View.GONE
                    tbTitle.visibility= View.VISIBLE
                    binding.backSearchView.visibility = View.GONE
                    search.visibility = View.GONE }
                R.id.profile -> {replaceFragment(ProfileFragment(),"Profile").apply {
                    searchView.visibility = View.GONE
                    search.visibility = View.GONE
                    binding.backSearchView.visibility = View.GONE
                    tbTitle.visibility= View.VISIBLE
                }
                }
                else -> {
                }
            }
            true
        }



}


    override fun onResume() {

        super.onResume()
    }


    private fun replaceFragment(fragment : Fragment, text :String?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
        val tbTitle = binding.tbTitle
        tbTitle!!.text = text
    }

}

