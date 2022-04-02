package com.a5k.pizza.data

sealed class AppState {
    data class SuccessListBanner(val item: List<Banners>) : AppState()
    data class SuccessListMenu(val item: List<Menu>) : AppState()
    data class Loading(val process: Int) : AppState()
    data class Error(val e: Throwable) : AppState()

}
