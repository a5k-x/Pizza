package com.a5k.pizza

import android.app.Application
import androidx.room.Room
import com.a5k.pizza.data.datasource.CacheDatabase


class App:Application() {

    companion object {
        lateinit var instance: App
        private const val DB_NAME = "dbcash.db"
        var instancedb: CacheDatabase? = null
        fun getInstance() = instancedb
            ?: throw RuntimeException("Database has not been created. Please call create(context)")

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (instancedb == null) {
            instancedb =
                Room.databaseBuilder(applicationContext!!, CacheDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}