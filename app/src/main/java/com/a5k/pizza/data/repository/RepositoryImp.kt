package com.a5k.pizza.data.repository

import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu
import com.a5k.pizza.data.datasource.IDataSource
import retrofit2.Call

class RepositoryImp(private val dataSource:IDataSource):Repository {
    override fun getListBanners(): Call<List<Banners>> {
        return dataSource.getListBanners()
    }

    override fun getListMenu(): Call<List<Menu>> {
       return dataSource.getListMenu()
    }
}