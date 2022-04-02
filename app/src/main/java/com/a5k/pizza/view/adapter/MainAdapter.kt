package com.a5k.pizza.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.a5k.pizza.data.Banners
import com.a5k.pizza.databinding.ItemBannerBinding


class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listBanners = listOf<Banners>()

    fun initBanner(listBanner: List<Banners>) {
        this.listBanners = listBanner
        notifyDataSetChanged()
    }


    inner class ViewHolderBanner(private val vb: ItemBannerBinding) :
        RecyclerView.ViewHolder(vb.root) {
        fun bind(position: Int) {
            val imageUrl = listBanners[position].download_url
            vb.imageBanner.load(imageUrl)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderBanner(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainAdapter.ViewHolderBanner).bind(position)

    }


    override fun getItemCount(): Int {
        return listBanners.size

    }

}