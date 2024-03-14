package com.example.electronicgadgetsapp

import java.io.Serializable

data class Product(val productName:String, val productDescription: String,val cost:Double, val imageResId: Int, val logoResId: Int):Serializable
