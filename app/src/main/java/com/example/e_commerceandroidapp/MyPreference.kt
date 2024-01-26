package com.example.e_commerceandroidapp

import android.content.Context

class MyPreference {


    companion object{
        fun saveData(context: Context, key: String, storeValue: String){
            val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(key, storeValue)
            editor.apply()
        }


        fun getData(context: Context?, key: String) :String {
            val sharedPreferences = context!!.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val text = sharedPreferences.getString(key, "")
            return text!!
        }
    }



}