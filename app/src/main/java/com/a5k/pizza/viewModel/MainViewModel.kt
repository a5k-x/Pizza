package com.a5k.pizza.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a5k.pizza.data.AppState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainViewModel:ViewModel() {

    private val liveData = MutableLiveData<AppState>()
    private val scope = CoroutineScope(Dispatchers.IO)
    fun getLiveData() = liveData
}