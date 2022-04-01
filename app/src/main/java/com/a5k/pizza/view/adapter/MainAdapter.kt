package com.a5k.pizza.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a5k.pizza.data.model.Banners
import com.a5k.pizza.databinding.ItemBannerBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listBanners = listOf<Banners>()

    fun init(listBanner: List<Banners>) {
        this.listBanners = listBanner
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val vb: ItemBannerBinding) : RecyclerView.ViewHolder(vb.root) {
        fun bind(position: Int) {
            
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}