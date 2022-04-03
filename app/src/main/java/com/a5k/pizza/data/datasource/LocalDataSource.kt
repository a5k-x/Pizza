package com.a5k.pizza.data.datasource

import androidx.lifecycle.MutableLiveData
import com.a5k.pizza.App
import com.a5k.pizza.data.AppState
import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu

class LocalDataSource(private val liveData: MutableLiveData<AppState>) : DataSource {


    private val db = App.instancedb?.dao()

    override fun getListBanners() {
        val data: List<Banners>? = db?.getAllListBanners()
        if (data != null) {
            liveData.postValue(AppState.SuccessListBanner(data))
        } else {
            liveData.postValue(AppState.Error(Throwable("Нет данных")))
        }
    }

    override fun getListMenu() {
        val data: List<Menu>? = db?.getAllListMenu()
        if (data != null) {
            liveData.postValue(AppState.SuccessListMenu(data))
        } else {
            liveData.postValue(AppState.Error(Throwable("Нет данных")))
        }
    }

    fun insertListBanners(data: List<Banners>) {
        if (data != null) {
            db?.addListBanners(data)
        }
    }

    fun insertListMenu(data: List<Menu>) {
        if (data != null) {
            db?.addListMenu(data)
        }
    }

    fun deleteListBanners() {
        db?.deleteAllBanners()
    }

    fun deleteListMenu() {
        db?.deleteAllMenu()
    }


}