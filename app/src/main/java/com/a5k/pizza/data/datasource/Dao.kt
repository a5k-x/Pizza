package com.a5k.pizza.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a5k.pizza.data.Banners
import com.a5k.pizza.data.Menu


@Dao
interface Dao {

    //output data list banners
    @Query("SELECT * FROM banners_table")
    fun getAllListBanners(): List<Banners>

    //output data list Menu
    @Query("SELECT * FROM menu_table")
    fun getAllListMenu(): List<Menu>

    //delete all banners
    @Query("DELETE FROM banners_table")
    fun deleteAllBanners()

    //delete all menu
    @Query("DELETE FROM menu_table")
    fun deleteAllMenu()

    //insert all banners
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListBanners(data: List<Banners>)

    //insert all menu
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListMenu(data: List<Menu>)
}