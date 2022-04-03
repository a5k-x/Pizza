package com.a5k.pizza.data.datasource

import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImp : RetrofitDataSource {

    override fun getListBanners(): Call<List<Banners>> {
        return getService().getListBanner()
    }

    override fun getListMenu(): Call<List<Menu>> {
        return getService().getListMenu()
    }

    private fun getService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        private val BASE_URL = "https://picsum.photos/v2/"
    }
}