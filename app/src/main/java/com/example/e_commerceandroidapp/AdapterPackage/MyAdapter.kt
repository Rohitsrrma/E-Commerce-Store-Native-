package com.example.e_commerceandroidapp.AdapterPackage



import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.e_commerceandroidapp.Activiity.CategoryFiilterActivity
import com.example.e_commerceandroidapp.Activiity.ProductDescription
import com.example.e_commerceandroidapp.DataModel.CartProductModel
import com.example.e_commerceandroidapp.DataModel.CategoryData
import com.example.e_commerceandroidapp.DataModel.OrderHistoryModel
import com.example.e_commerceandroidapp.DataModel.ProductModel
import com.example.e_commerceandroidapp.R
import com.example.e_commerceandroidapp.datasource.TestData
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.round


class MyAdapterRecent(val ctx: Context) : RecyclerView.Adapter<MyAdapterRecent.Holder>(){
    constructor(ctx: Context, list:MutableList<ProductModel>):this(ctx) {
        dataList = list
        filteredList = kotlin.collections.ArrayList(dataList)
    }

    var dataList : MutableList<ProductModel>?=null
    var filteredList:MutableList<ProductModel>?=null


    var listFilter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults? {
            val filter_list: MutableList<ProductModel> = ArrayList()
            if (charSequence == null || charSequence.length == 0) {
                filter_list.addAll(filteredList!!)
            } else {
                val filterPattern = charSequence.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
                for (item in filteredList!!) {
                    if (item.name.toLowerCase().contains(filterPattern)) {
                        filter_list.add(item)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filter_list
            return filterResults
        }

        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            dataList!!.clear()
            dataList!!.addAll(filterResults.values as List<ProductModel>)
            Log.d("DatalistSize","Size =${dataList!!.size} ")
            notifyDataSetChanged()
        }
    }

     fun getfilterList() : Filter{
        return listFilter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_recent,parent,false)

        return Holder(view)

    }

    override fun getItemCount(): Int {

        return dataList!!.size

    }
    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.itemName.text = dataList!![position].name
        holder.itemPrice.text = dataList!![position].price.toString()+" USD"

        Picasso.get().load(dataList!![position].thumb).into(holder.image)

        holder.itemView.setOnClickListener{

            val intent = Intent(ctx,ProductDescription::class.java)
            val productModel = ProductModel(dataList!![position].name,dataList!![position].price,dataList!![position].thumb)

            intent.putExtra("productModel",productModel)
            intent.putExtra("position",position)



            ctx.startActivity(intent)
        }
    }

    class Holder(itemView: View) : ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imageViewrecent)
        val itemName = itemView.findViewById<TextView>(R.id.textViewItemNameRecent)
        val itemPrice = itemView.findViewById<TextView>(R.id.textViewItemPriceRecent)
    }
}











class MyAdapterCategory(val ctx: Context) :  RecyclerView.Adapter<MyAdapterCategory.Holder>(){
   constructor(ctx: Context, list : MutableList<CategoryData>) : this(ctx){
       datalist = list
       filteredList = kotlin.collections.ArrayList(datalist)
   }
    var datalist : MutableList<CategoryData>?=null
    var filteredList : MutableList<CategoryData>?=null


    var listFilter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults? {
            val filter_list: MutableList<CategoryData> = ArrayList()
            if (charSequence == null || charSequence.length == 0) {
                filter_list.addAll(filteredList!!)
            } else {
                val filterPattern = charSequence.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
                for (item in filteredList!!) {
                    if (item.categoryName.toLowerCase().contains(filterPattern)) {
                        filter_list.add(item)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filter_list
            return filterResults
        }


        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            datalist!!.clear()
            datalist!!.addAll(filterResults.values as List<CategoryData>)
            Log.d("DatalistSize","Size =${datalist!!.size} ")
            notifyDataSetChanged()
        }
    }


    fun getfilterList() : Filter{
        return listFilter
    }



    class Holder(itemView: View): ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val categoryName = itemView.findViewById<TextView>(R.id.ItemNameText)
        val itemsTotal = itemView.findViewById<TextView>(R.id.itemCountText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_view_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
       return datalist!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.categoryName.text = datalist!![position].categoryName
        holder.itemsTotal.text = "5 Item(s)"
        holder.imageView.setImageResource(datalist!![position].categoryImage)

        holder.itemView.setOnClickListener {

            val intent = Intent(ctx,CategoryFiilterActivity::class.java)
            intent.putExtra("cateGory",datalist!![position].categoryId)
            intent.putExtra("cateGoryName",datalist!![position].categoryName)


            ctx.startActivity(intent)
        }

    }



}







class MyAdapterShoppingCart(val list: List<CartProductModel>,val ctx : Context) :RecyclerView.Adapter<MyAdapterShoppingCart.Holder>(){
    class Holder(itemView: View): ViewHolder(itemView) {
        val nameItemText = itemView.findViewById<TextView>(R.id.shoppingCartItemName)
        val priceItemText = itemView.findViewById<TextView>(R.id.shoppingCartItemPrice)
        val imageItem = itemView.findViewById<ImageView>(R.id.shoppingCartItemImage)
        val totalpriceitem = itemView.findViewById<TextView>(R.id.TV_total_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder  {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_cart_view,parent,false)
        return Holder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.nameItemText.text = list[position].productModel.name
        holder.priceItemText.text = (list[position].productModel.price.toString()+" USD "+" x "+ list[position].quantity)

        val totalprice = ((list[position].productModel.price* list[position].quantity))
        val roundedNumber = String.format("%.2f", totalprice)
        holder.totalpriceitem.text = (roundedNumber.toString() + " USD")
        Picasso.get().load(list[position].productModel.thumb).into(holder.imageItem)

        holder.itemView.setOnClickListener{
            val dialog= Dialog(ctx)
            dialog.setContentView(R.layout.delete_order_single)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
            val yes = dialog.findViewById<Button>(R.id.yes_single_order_delete)
            yes.setOnClickListener {
                TestData.cartProductList.removeAt(position)
                notifyDataSetChanged()
                dialog.dismiss()
            }


            val no = dialog.findViewById<Button>(R.id.no_single_order_delete)
            no.setOnClickListener {
                dialog.dismiss()
            }

        }



    }

}

class OrderHistoryAdapter(val list:List<OrderHistoryModel>,val ctx: Context): RecyclerView.Adapter<OrderHistoryAdapter.Holder>() {

    class Holder(itemView: View) : ViewHolder(itemView){
        val purchaseid = itemView.findViewById<TextView>(R.id.purchase_Code_Text_View_Recycler_View)
        val dateorderhistory = itemView.findViewById<TextView>(R.id.order_histroy_date)
        val totalprice = itemView.findViewById<TextView>(R.id.order_histroy_date_total_Price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_history_recycler_view,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {


        holder.dateorderhistory.text = TestData.orderHistory[position].Date

        holder.purchaseid.text =  TestData.orderHistory[position].purchasecode


        holder.totalprice.text = TestData.orderHistory[position].taxprice.toString()+" USD"

        holder.itemView.setOnClickListener{

            showBottomSheetDialog(ctx,position)
        }
        holder.itemView.setOnLongClickListener (
            OnLongClickListener {
                val dialog = Dialog(ctx)
                dialog.setContentView(R.layout.delete_order_single)
                dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                dialog.show()
                val yes = dialog.findViewById<Button>(R.id.yes_single_order_delete)
                yes.setOnClickListener {
                    TestData.orderHistory.removeAt(position)
                    notifyDataSetChanged()
                    dialog.dismiss()
                }


                val no = dialog.findViewById<Button>(R.id.no_single_order_delete)
                no.setOnClickListener {
                    dialog.dismiss()
                }

                true
            }

        )


    }




    }
    fun showBottomSheetDialog(ctx: Context,position: Int) {
        val bottomSheetDialog = BottomSheetDialog(ctx)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout)
        val copy = bottomSheetDialog.findViewById<ImageView>(R.id.copy_purchase_code_ImageView)
        val bottom_sheet_datetime = bottomSheetDialog.findViewById<TextView>(R.id.bottom_sheet_datetime)

        val bottom_sheet_totalpricewithtax = bottomSheetDialog.findViewById<TextView>(R.id.bottom_sheet_totalpricewithtax)
        val order_summary_textView = bottomSheetDialog.findViewById<TextView>(R.id.order_summary_textView)
        val purchase_Code_Text_View = bottomSheetDialog.findViewById<TextView>(R.id.purchase_Code_Text_View)
        purchase_Code_Text_View?.text = TestData.orderHistory[position].purchasecode
        bottom_sheet_datetime?.text = TestData.orderHistory[position].Date+", "+TestData.orderHistory[position].time
        bottom_sheet_totalpricewithtax?.text = TestData.orderHistory[position].taxprice.toString()+" USD"
        order_summary_textView?.text = TestData.orderHistory[position].alldetails
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val textToCopy = TestData.orderHistory[position].purchasecode // Replace this with the text you want to copy




        copy?.setOnClickListener{
            val clip = ClipData.newPlainText("label", textToCopy)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(ctx,"Purchase Code Copied",Toast.LENGTH_SHORT).show()

        }


        bottomSheetDialog.show()
    }



