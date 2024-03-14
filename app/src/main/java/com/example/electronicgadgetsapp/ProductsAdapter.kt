package com.example.electronicgadgetsapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
//    private val products: List<Product>,
//    private val onItemClicked: (Product) -> Unit
//) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.product_item, parent, false)
//        return ProductViewHolder(view, onItemClicked)
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        holder.bind(products[position])
//    }
//
//    override fun getItemCount(): Int = products.size
//
//    class ProductViewHolder(itemView: View, private val onItemClicked: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
//        private val productNameTextView: TextView = itemView.findViewById(R.id.productName)
//        private val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescription)
//        private val productCostTextView: TextView = itemView.findViewById(R.id.productCost)
//        private val productLogoImageView: ImageView = itemView.findViewById(R.id.productLogo)
//        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)
//
//        @SuppressLint("SetTextI18n")
//        fun bind(product: Product) {
//            productNameTextView.text = product.productName
//            productDescriptionTextView.text = product.productDescription
//            productCostTextView.text = " $${product.cost}"
//            productImageView.setImageResource(product.imageResId)
//            productLogoImageView.setImageResource(product.logoResId)
//
//            itemView.setOnClickListener {
//                //onItemClicked(product)
//
//                val context = it.context
//                val detailIntent = Intent(context, ProductDetailActivity::class.java).apply {
//                    putExtra("productName", product.productName)
//                    putExtra("productDescription", product.productDescription)
//                    putExtra("productCost", product.cost)
//                    putExtra("imageResId", product.imageResId)
//                    putExtra("logoResId", product.logoResId)
//                }
//                context.startActivity(detailIntent)
//            }
//        }
//    }
    private val context: Context,
    private val productsList: ArrayList<Product>,
    private val  itemClickedListener: ItemClickedListener
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    interface ItemClickedListener{
        fun onItemClickListener(product: Product)
        fun onAddClickListener(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productsList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productNameTextView: TextView = itemView.findViewById(R.id.productName)
        private val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescription)
        private val productCostTextView: TextView = itemView.findViewById(R.id.productCost)
        private val productLogoImageView: ImageView = itemView.findViewById(R.id.productLogo)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)
        private val btnAdd = itemView.findViewById<Button>(R.id.btnAdd)


        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            productNameTextView.text = product.productName
            productDescriptionTextView.text = product.productDescription
            productCostTextView.text = " $${product.cost}"
            productImageView.setImageResource(product.imageResId)
            productLogoImageView.setImageResource(product.logoResId)

            itemView.setOnClickListener {
                //onItemClicked(product)

                val context = it.context
                val detailIntent = Intent(context, ProductDetailActivity::class.java).apply {
                    putExtra("productName", product.productName)
                    putExtra("productDescription", product.productDescription)
                    putExtra("productCost", product.cost)
                    putExtra("imageResId", product.imageResId)
                    putExtra("logoResId", product.logoResId)
                }
                context.startActivity(detailIntent)
            }

            btnAdd.setOnClickListener{
                itemClickedListener.onAddClickListener(product)
            }
        }


//    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        fun bind(product: Product) {
//            val tvPrice =     itemView.findViewById<TextView>(R.id.productCost)
//            val tvDescription=     itemView.findViewById<TextView>(R.id.productDescription)
//            val tvProductName = itemView.findViewById<TextView>(R.id.productName)
//            val  ivLogo = itemView.findViewById<ImageView>(R.id.productLogo)
//            val ivProductImage = itemView.findViewById<ImageView>(R.id.productImage)
//            val btnAdd = itemView.findViewById<Button>(R.id.btnAdd)
//
//
//
//            tvPrice.text = "$ ${product.cost.toString()}"
//            tvDescription.text = product.productDescription
//            tvProductName.text = product.productName
//            ivProductImage.setImageResource(product.imageResId)
//            ivLogo.setImageResource(product.logoResId)
//
//
//            itemView.setOnClickListener{
//                itemClickedListener.onItemClickListener(product)
//            }
//            btnAdd.setOnClickListener{
//                itemClickedListener.onAddClickListener(product)
//            }
//        }
    }
}
