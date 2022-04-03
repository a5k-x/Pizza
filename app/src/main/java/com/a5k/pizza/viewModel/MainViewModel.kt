package com.a5k.pizza.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a5k.pizza.data.AppState
import com.a5k.pizza.data.datasource.LocalDataSource
import com.a5k.pizza.data.datasource.RemoteDataSource
import com.a5k.pizza.data.datasource.RetrofitImp
import com.a5k.pizza.data.repository.RepositoryImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val liveData = MutableLiveData<AppState>()
    private val liveDataMenu = MutableLiveData<AppState>()
    fun getLiveDataBanner() = liveData
    fun getLiveDataMenu() = liveDataMenu
    private val scope = CoroutineScope(Dispatchers.IO)

    fun getListBanner(networkStats: Boolean) {
    scope.launch {
        if (networkStats) {
            RepositoryImp(RemoteDataSource(RetrofitImp(),liveData)).getListBanners()
        } else {
            RepositoryImp(LocalDataSource(liveData)).getListBanners()
        }
    }

    }

    fun getListMenu(networkStats: Boolean) {
        scope.launch {
            if (networkStats) {
                 RepositoryImp(RemoteDataSource(RetrofitImp(),liveDataMenu)).getListMenu()
            } else {
                 RepositoryImp(LocalDataSource(liveDataMenu)).getListMenu()
            }
        }

    }


}

