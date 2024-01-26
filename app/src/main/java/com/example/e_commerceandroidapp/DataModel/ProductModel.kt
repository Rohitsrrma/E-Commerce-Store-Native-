package com.example.e_commerceandroidapp.DataModel

import android.widget.Switch

data class ProductModel(
    var name :String,
    var price :Double,
    var thumb :String?="",
    var category : Int?=0) : java.io.Serializable {

    class ProductType {

        companion object{
            val Fashion  =2
            val Electronics =1
            val BabyGear      =3
            val HealthSports = 5
            val Industry  = 6
            val Furniture = 4
        }
    }
}



