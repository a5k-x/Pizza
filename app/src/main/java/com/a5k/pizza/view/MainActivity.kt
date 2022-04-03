package com.a5k.pizza.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.a5k.pizza.App
import com.a5k.pizza.R
import com.a5k.pizza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IMainViewScreen {

    lateinit var navigation: NavController
    private var vb:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        App.instance
        App.instancedb

        initListenerButtomNavigation()
    }


    private fun initListenerButtomNavigation(){
        navigation = Navigation.findNavController(this, R.id.fragment_container)

        vb?.bottomNavigation?.setOnItemSelectedListener { it ->
            when (it.itemId){
                R.id.page_menu -> {toMenuFragment()}
                R.id.page_union -> {true}
                R.id.page_trash -> {true}
                else -> {true}
            }
        }
    }

    override fun toMenuFragment():Boolean {
        navigation.navigate(R.id.menuListFragment)
        return true
    }

    override fun onPause() {
        super.onPause()

    }
}