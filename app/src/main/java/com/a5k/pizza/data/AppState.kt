package com.a5k.pizza.data


sealed class AppState {
    data class Success(val item: Any) : AppState()
    data class Loading(val process: Int) : AppState()
    data class Error(val e: Throwable) : AppState()

}
