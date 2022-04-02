package com.a5k.pizza.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a5k.pizza.data.AppState
import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu
import com.a5k.pizza.data.datasource.RetrofitImp
import com.a5k.pizza.data.repository.Repository
import com.a5k.pizza.data.repository.RepositoryImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {

    private val liveData = MutableLiveData<AppState>()
    private val liveDataMenu = MutableLiveData<AppState>()
    private val scope = CoroutineScope(Dispatchers.IO)
    fun getLiveData() = liveData
    fun getLiveDataMenu() = liveDataMenu
    fun getListBanner(){
        scope.launch {
            val data = RepositoryImp(RetrofitImp()).getListBanners()
            data.enqueue(object : Callback<List<Banners>> {
                override fun onResponse(
                    call: Call<List<Banners>>,
                    response: Response<List<Banners>>
                ) {
                    when (response.code()){
                        200 -> liveData.postValue(response.body()?.let { AppState.SuccessListBanner(it) })
                        else -> liveData.postValue(AppState.Error(Throwable(response.code().toString())))
                    }
                }

                override fun onFailure(call: Call<List<Banners>>, t: Throwable) {
                   liveData.postValue(AppState.Error(t))
                }

            })
        }

    }

    fun getListMenu(){

        scope.launch {
            val data = RepositoryImp(RetrofitImp()).getListMenu()
            data.enqueue(object : Callback<List<Menu>> {
                override fun onResponse(
                    call: Call<List<Menu>>,
                    response: Response<List<Menu>>
                ) {
                    when (response.code()){
                        200 -> liveDataMenu.postValue(response.body()?.let { AppState.SuccessListMenu(it) })
                        else -> liveDataMenu.postValue(AppState.Error(Throwable(response.code().toString())))
                    }
                }

                override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                    liveDataMenu.postValue(AppState.Error(t))
                }

            })
        }
    }

}