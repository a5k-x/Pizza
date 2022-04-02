package com.a5k.pizza.data

data class Banners(
    val id:String,
    val author:String,
    val download_url:String,
    val flag:Boolean = false

)
//for single adapter (two types)
data class Menu(
    val id:String,
    val author:String,
    val download_url:String,
    val flag:Boolean = true
)
