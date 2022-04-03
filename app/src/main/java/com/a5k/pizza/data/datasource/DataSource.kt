package com.a5k.pizza.data.datasource

import androidx.lifecycle.MutableLiveData
import com.a5k.pizza.data.AppState

interface DataSource {
    fun getListBanners()
    fun getListMenu()
}