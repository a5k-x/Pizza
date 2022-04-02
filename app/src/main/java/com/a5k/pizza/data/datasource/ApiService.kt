package com.a5k.pizza.data.datasource

import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("list?page=20&limit=5")
    fun getListBanner(): Call<List<Banners>>

    @GET("list?page=8&limit=10")
    fun getListMenu(): Call<List<Menu>>
}