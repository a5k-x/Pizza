package com.a5k.pizza.data.datasource

import androidx.lifecycle.MutableLiveData
import com.a5k.pizza.data.AppState
import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val retrofit: RetrofitDataSource, private val liveData: MutableLiveData<AppState>) : DataSource {
    override fun getListBanners() {
       val data = retrofit.getListBanners()
        data.enqueue(object : Callback<List<Banners>> {
            override fun onResponse(
                call: Call<List<Banners>>,
                response: Response<List<Banners>>
            ) {
                when (response.code()) {
                    200 -> liveData.postValue(
                        response.body()?.let { AppState.SuccessListBanner(it) })

                    else -> liveData.postValue(
                        AppState.Error(
                            Throwable(
                                response.code().toString()
                            )
                        )
                    )
                }
            }

            override fun onFailure(call: Call<List<Banners>>, t: Throwable) {
                liveData.postValue(AppState.Error(t))
            }
        })

    }

    override fun getListMenu() {
       val data = retrofit.getListMenu()
        data.enqueue(object : Callback<List<Menu>> {
            override fun onResponse(
                call: Call<List<Menu>>,
                response: Response<List<Menu>>
            ) {
                when (response.code()) {
                    200 -> liveData.postValue(
                        response.body()?.let { AppState.SuccessListMenu(it) })
                    else -> liveData.postValue(
                        AppState.Error(
                            Throwable(
                                response.code().toString()
                            )
                        )
                    )
                }
            }

            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                liveData.postValue(AppState.Error(t))
            }
        })

    }

}