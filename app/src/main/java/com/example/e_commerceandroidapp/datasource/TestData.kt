package com.example.e_commerceandroidapp.datasource

import com.example.e_commerceandroidapp.DataModel.CartProductModel
import com.example.e_commerceandroidapp.DataModel.CategoryData
import com.example.e_commerceandroidapp.DataModel.OrderHistoryModel
import com.example.e_commerceandroidapp.DataModel.ProductModel
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.*
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.Companion.BabyGear
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.Companion.Electronics
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.Companion.Fashion
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.Companion.Furniture
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.Companion.HealthSports
import com.example.e_commerceandroidapp.DataModel.ProductModel.ProductType.Companion.Industry
import com.example.e_commerceandroidapp.R

class TestData {

    companion object {

        var productList = mutableListOf<ProductModel>()


        fun addtotestproduct() {
            productList.add(
                ProductModel(
                    "JBL Flip Essential IPX7 Waterproof 16 W Bluetooth Speaker  (Grey, Stereo Channel)",
                    200.0,
                    "https://rukminim1.flixcart.com/image/612/612/k4x2du80/speaker/mobile-tablet-speaker/c/z/f/jbl-flip-essential-original-imafnpuhahqwvwhw.jpeg?q=70"
                   , Electronics
                )
            )
            productList.add(
                ProductModel(
                    "Nike Shoes",
                    40.0,
                    "https://rukminim1.flixcart.com/image/832/832/xif0q/shoe/h/j/8/-original-imagjzqf4dkmaznj.jpeg?q=70",
                    Fashion
                )
            )
            productList.add(
                ProductModel(
                    "SAMSUNG Galaxy S21 FE 5G (Lavender, 128 GB)  (8 GB RAM)",
                    899.0,
                    "https://rukminim1.flixcart.com/image/312/312/l30hmkw0/mobile/w/j/o/galaxy-s21-fe-5g-sm-g990ewziinu-samsung-original-image8dzwv3bch4k.jpeg?q=70"
                    ,Electronics)
            )
            productList.add(
                ProductModel(
                    "APPLE 2022 MacBook AIR M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
                    400.0,
                    "https://rukminim1.flixcart.com/image/832/832/xif0q/computer/t/l/k/-original-imagfdf4gyhvzmkf.jpeg?q=70"
                    ,Electronics  )
            )
            productList.add(
                ProductModel(
                    "APPLE iPhone 14 (Midnight, 128 GB)", 149.0,
                    "https://rukminim1.flixcart.com/image/312/312/xif0q/mobile/9/e/e/-original-imaghx9q5rvcdghy.jpeg?q=70"
                    ,Electronics  )
            )
           productList.add(
               ProductModel(
                   "limraz furniture L 56 Engineered Wood Study Table  (Free Standing, Finish Color - brown, Pre-assembled)",
                   499.0,
                   "https://rukminim1.flixcart.com/image/832/832/k6l2vm80/computer-table/z/y/a/mdf-fk-28-limraz-furniture-brown-original-imafzy9ytkbegxg4.jpeg?q=70"
                   ,ProductModel.ProductType.Furniture)
           )
           productList.add(
               ProductModel(
                   "Gizmore GizFit Ultra BT Calling Smartwatch With 1.69 HD Display| 60+ Sports Mode Smartwatch (Grey Strap, Regular)",
                   899.0,
                   "https://rukminim1.flixcart.com/image/832/832/xif0q/smartwatch/j/r/d/-original-imaggxsxbpnghba5.jpeg?q=70"
                   , Electronics
               )
           )
           productList.add(
               ProductModel(
                   "jacckes Anti-slip PVC Gymnastic Mat Sport Health Lose Weight Fitness Exercise Yoga Mat 6 mm Yoga Mat",
                   400.0,
                   "https://rukminim1.flixcart.com/image/832/832/l0fm07k0/sport-mat/7/r/s/yoga-mat-green-6mm-yoga-mat-6-tejas-feb-original-imagc7wkpmrrynpt.jpeg?q=70"
                   ,ProductModel.ProductType.HealthSports
               )
           )
            productList.add(
               ProductModel(
                   "PARKER Classic Stainless Steel Gold Ball Pen  (Blue)",
                   35.0,
                   "https://rukminim1.flixcart.com/image/832/832/kolsscw0/pen/o/5/q/9000016330-parker-original-imag3ysyuetrbjgh.jpeg?q=70"
                   , Industry
               )
           )
            productList.add(
               ProductModel(
                   "Men Solid Polo Neck Black T-Shirt",
                   100.0,
                   "https://rukminim1.flixcart.com/image/832/832/l3929ow0/t-shirt/4/5/y/xxl-238479008-jack-jones-original-imageetmdqamcq3n.jpeg?q=70"
                   , Fashion
               )
           )
            productList.add(
               ProductModel(
                   "Miss & Chief by Flipkart Premium Baby Stroller  (3, Dark Blue)",
                   90.0,
                   "https://rukminim1.flixcart.com/image/612/612/ktuewsw0/stroller-pram/v/j/9/premium-baby-5-point-harness-3-tr8008db-stroller-miss-chief-original-imag73tbh3msh7pu.jpeg?q=70"
                   , BabyGear
               )
           )
        productList.add(
               ProductModel(
                   "Men Solid Round Neck Black T-Shirt",
                   9.99
                   ,"https://rukminim1.flixcart.com/image/832/832/xif0q/t-shirt/8/x/y/s-mens-compression-top-t-shirt-with-pant-kyk-original-imagg7bnqnnwhvjj.jpeg?q=70"
                   , Fashion
               )
           )
        productList.add(
               ProductModel(
                   "Men Solid Tuxedo Style Casual Blazer  (Maroon)",
                   24.0
                   ,"https://rukminim1.flixcart.com/image/832/832/xif0q/blazer/d/z/2/xl-482249-v-mart-original-imaghghqez7qzphu.jpeg?q=70"
                   , Fashion
               )
           )
       productList.add(
               ProductModel(
                   "UV Protection Retro Square Sunglasses (54)  (For Men & Women, Black)\n",
                   12.99
                   ,"https://rukminim1.flixcart.com/image/832/832/l4hcx3k0/sunglass/n/i/p/medium-lw-8780-bajero-original-imagfdd6sbhqtyg3.jpeg?q=70"
                   , Fashion
               )
           )
       productList.add(
               ProductModel(
                   "Miss & Chief by Flipkart Baby 3-in-1 High Chair  (Green, White)",
                   123.49
                   ,"https://rukminim1.flixcart.com/image/832/832/kelptow0/chair/d/j/p/baby-3-in-1-high-chair-8850-2-high-chair-miss-chief-original-imafv8pu4xz3e6yp.jpeg?q=70"
                   , BabyGear
               )
           )
       productList.add(
               ProductModel(
                   "Honey Boo Adjustable Baby Carrier Bag (Navy-Cream, Front carry facing out) Baby Carrier Baby Carrier  (Blue, Front carry facing out)",
                   179.0
                   ,"https://rukminim1.flixcart.com/image/832/832/xif0q/baby-carrier-cuddler/3/l/6/12-adjustable-baby-carrier-bag-navy-cream-front-carry-facing-out-original-imaggxahjycyujnk.jpeg?q=70"
                   , BabyGear
               )
           )
       productList.add(
               ProductModel(
                   "AE Silicone Baby fruit Feeder/BPA Free/Food Feeder/Silicone Food Nibbler/ Feeder  (Multiple)",
                   9.99
                   ,"https://rukminim1.flixcart.com/image/832/832/km0x5zk0/teether-soother/j/c/d/silicone-baby-fruit-feeder-bpa-free-food-feeder-silicone-food-original-imagfyr98hfg5bwj.jpeg?q=70"
                   , BabyGear
               )
           )
         productList.add(
               ProductModel(
                   "Crafts For You Beautiful printed 200 ml water bottle sipper with 2 handles for kids (set of 2)  (Multicolor)",
                   14.99
                   ,"https://rukminim1.flixcart.com/image/832/832/juwzf680/sipper-cup/v/s/x/200-beautiful-printed-200-ml-water-bottle-sipper-with-2-handles-original-imaffwykvenh7ddh.jpeg?q=70"
                   , BabyGear
               )
           )
         productList.add(
               ProductModel(
                   "Umar Enterprises Wall T.V entertainment unit set up box stand & Wifi stand MDF Wall hanging , mounted , floating , wall decorative Wooden wall shelf Living room & Bedroom set up box stand Engineered Wood TV Entertainment Unit  (Finish Color - Brown, Pre-assembled)",
                   299.00
                   ,"https://rukminim1.flixcart.com/image/832/832/l4a7pu80/tv-entertainment-unit/y/n/v/15-50-mdf-2-0-a-1149-umar-enterprises-10-70-brown-original-imagf7nmkkkzfeek.jpeg?q=70"
                   , Furniture
               )
           )
         productList.add(
               ProductModel(
                   "Flipkart Perfect Homes Carol Engineered Wood King Bed  (Finish Color - Espresso, Delivery Condition - Knock Down)",
                    1599.00
                   ,"https://rukminim1.flixcart.com/image/832/832/k687wy80/bed/f/g/u/king-na-particle-board-bkwen00nhbs200p-flipkart-perfect-homes-original-imafzqnfp58xjgjy.jpeg?q=70"
                   , Furniture
               )
           )
         productList.add(
               ProductModel(
                   "Mom's Moon Extra Long Rocking Chairpad Microfibre Solid Chair Pad Pack of 1  (Wine)",
                   39.99
                   ,"https://rukminim1.flixcart.com/image/832/832/k0e66q80/pillow/y/x/g/extra-long-rocking-chairpad-mm055-mom-s-moon-original-imafjetg8wvfqhgj.jpeg?q=70"
                   , Furniture
               )
           )
         productList.add(
               ProductModel(
                   "Flipkart Perfect Homes Julian Engineered Wood 3 Door Wardrobe  (Finish Color - Chocolate Wenge, Mirror Included, Knock Down)",
                   1599.00
                   ,"https://rukminim1.flixcart.com/image/832/832/xif0q/wardrobe-closet/v/i/y/-original-imaggr657n9aejcc.jpeg?q=70"
                   , Furniture
               )
           )
            productList.add(
               ProductModel(
                   "Flipkart Perfect Homes Studio Metal Shoe Stand  (Black, 5 Shelves, DIY(Do-It-Yourself))",
                   29.99
                   ,"https://rukminim1.flixcart.com/image/832/832/k0sgl8w0/shoe-rack/y/n/d/ben-sr-123a-benesta-original-imafkg6jyhathhak.jpeg?q=70"
                   ,ProductModel.ProductType.HealthSports
               )
           )
            productList.add(
               ProductModel(
                   "L'AVENIR Fitness 20KG (4 * 3kg + 4 * 2kg) PVC Weight Plates + 2 Dumbbell Rods Adjustable Dumbbell  (20 kg)",
                    35.99
                   ,"https://rukminim1.flixcart.com/image/832/832/l3es13k0/dumbbell/x/q/y/fitness-20kg-4-3kg-4-2kg-pvc-weight-plates-2-dumbbell-rods-20-l-original-imagegzbxdhcbbk8.jpeg?q=70"
                   ,HealthSports
               )
           )
            productList.add(
               ProductModel(
                   "Isopure Low Carb 100% Isolate Powder with 25gm Protein per serve Whey Protein  (3.4 kg, Dutch Chocolate)",
                   17.99
                   ,"https://rukminim1.flixcart.com/image/832/832/kd69z0w0/protein-supplement/h/f/2/low-carb-nbi7-5dc-isopure-original-imafu4ypv2tuzaj5.jpeg?q=70"
                   ,HealthSports
               )
           )
            productList.add(
               ProductModel(
                   "Adrenex by Flipkart BPA Free Gym Bottle with Single Supplement Storage Compartment and Mixer Ball 700 ml Shaker  (Pack of 1, Black, Grey, Plastic)",
                   8.99
                   ,"https://rukminim1.flixcart.com/image/832/832/jy3anbk0/bottle/r/7/6/700-bpa-free-gym-bottle-with-single-supplement-storage-original-imafgccty2farjmz.jpeg?q=70"
                   ,HealthSports
               )
           )
            productList.add(
               ProductModel(
                   "Men & Women Brown Messenger Bag - Regular Size",
                   16.00
                   ,"https://rukminim1.flixcart.com/image/832/832/klfhk7k0/bag/w/p/n/laptop-bag-messenger-25-ltrs-leather-office-laptop-bag-for-men-original-imagyk42nykpz93p.jpeg?q=70"
                   ,ProductModel.ProductType.Industry
               )
           )
       productList.add(
               ProductModel(
                   "Care 4 lock diary A5 Diary Ruled 200 Pages  (Black)",
                   23.99
                   ,"https://rukminim1.flixcart.com/image/832/832/jzu60sw0/diary-notebook/2/h/s/care-4-lock-diary-exclusive-number-lock-diary-black-original-imafjpq3tpg4qyvw.jpeg?q=70"
                   ,ProductModel.ProductType.Industry
               )
           )
       productList.add(
               ProductModel(
                   "Arham 6 Compartments Wooden Pen Stand / Desk Organizer / Mobile Holder.  (Brown)",
                   57.99
                   ,"https://rukminim1.flixcart.com/image/832/832/xif0q/desk-organizer/j/l/d/wooden-pen-stand-desk-organizer-pen-pencil-stand-with-drawer-original-imagmdgxqfmfqcpt.jpeg?q=70"
                   ,ProductModel.ProductType.Industry
               )
           )
       productList.add(
               ProductModel(
                   "Shivarth 8 Compartments Acrylic Pen Stand  (Black)",
                   13.99
                   ,"https://rukminim1.flixcart.com/image/832/832/kv5kfww0/desk-organizer/a/v/4/black-acrylic-pen-holderstand-globe-flag-paper-calendar-in-this-original-imag84apuebhwtup.jpeg?q=70"
                   ,ProductModel.ProductType.Industry
               )
           )
        }

        var cartProductList = mutableListOf<CartProductModel>()


        var orderHistory = mutableListOf<OrderHistoryModel>()

        var categoryList = mutableListOf<CategoryData>()

        fun addtoCategoryList(){

            categoryList.add(CategoryData(R.drawable.electronics, "Electronics & Gadgets", "5 item(s)",ProductModel.ProductType.Electronics))
            categoryList.add(CategoryData(R.drawable.fashion, "Fashion", "5 item(s)",ProductModel.ProductType.Fashion),)
            categoryList.add(CategoryData(R.drawable.baby, "Baby Gear", "5 item(s)",ProductModel.ProductType.BabyGear))
            categoryList.add(CategoryData(R.drawable.furniture, "Home & Furniture", "5 item(s)",ProductModel.ProductType.Furniture))
            categoryList.add(CategoryData(R.drawable.healthsports, "Health & Sports", "5 item(s)",ProductModel.ProductType.HealthSports))
            categoryList.add(CategoryData(R.drawable.printer, "Office & Industry", "5 item(s)",ProductModel.ProductType.Industry))

        }


    }


}