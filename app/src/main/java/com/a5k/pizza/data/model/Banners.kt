package com.a5k.pizza.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banners_table")
data class Banners(
    @field:PrimaryKey(autoGenerate = false) val id:Int,
    @field:ColumnInfo(name = "author") val author:String,
    @field:ColumnInfo(name = "download_url") val download_url:String,
)
@Entity(tableName = "menu_table")
data class Menu(
    @field:PrimaryKey(autoGenerate = false)  val id:Int,
    @field:ColumnInfo(name = "author") val author:String,
    @field:ColumnInfo(name = "download_url") val download_url:String,
)
