package com.example.project_mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(context: Context, private val products: List<ProductItem>) :
    ArrayAdapter<ProductItem>(context, R.layout.item_product, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_product, parent, false)

        val product = products[position]

        val imgProduct = view.findViewById<ImageView>(R.id.imgProduct)
        val tvProductTitle = view.findViewById<TextView>(R.id.tvProductTitle)
        val tvProductPrice = view.findViewById<TextView>(R.id.tvProductPrice)

        tvProductTitle.text = product.title
        tvProductPrice.text = product.price
        imgProduct.setImageResource(product.imageResId)

        return view
    }
}
