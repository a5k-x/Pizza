package com.a5k.pizza.data.datasource


import androidx.room.Database
import androidx.room.RoomDatabase
import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu

@Database(entities = [Banners::class,Menu::class], version = 1, exportSchema = true)
abstract class CacheDatabase:RoomDatabase() {
    abstract fun dao():Dao
}