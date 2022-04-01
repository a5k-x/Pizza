package com.a5k.pizza.data.repository


import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu
import retrofit2.Call

interface Repository {
    fun getListBanners():Call<List<Banners>>
    fun getListMenu(): Call<List<Menu>>
}