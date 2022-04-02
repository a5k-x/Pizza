package com.a5k.pizza.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.a5k.pizza.data.Menu
import com.a5k.pizza.databinding.ItemMenuBinding

class MenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var listMenu = listOf<Menu>()


    fun initMenu(listMenu: List<Menu>) {
        this.listMenu = listMenu
        notifyDataSetChanged()
    }


    inner class ViewHolderMenuItem(private val vb: ItemMenuBinding) : RecyclerView.ViewHolder(vb.root) {
        fun bind(position: Int) {
            val id = listMenu[position].id
            val title = listMenu[position].author
            val description = listMenu[position].author
            val imageUrl = listMenu[position].download_url
            vb.imageItemMenu.load(imageUrl)
            vb.menuTextTitle.text = title
            vb.menuTextDescription.text = description
            val av:Int = id.toInt() * 3
            vb.orderButton.text = "$PRICE_ORDER${av}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderMenuItem(ItemMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))

        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MenuAdapter.ViewHolderMenuItem).bind(position)
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
    companion object{
        private const val PRICE_ORDER = "от "
    }
}




