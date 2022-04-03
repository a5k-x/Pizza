package com.a5k.pizza.data.repository

import com.a5k.pizza.data.datasource.DataSource

class RepositoryImp(private val dataSource: DataSource):Repository {

    override fun getListBanners() {
       dataSource.getListBanners()
    }

    override fun getListMenu() {
       dataSource.getListMenu()
    }

}