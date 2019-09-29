package com.dngwjy.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dngwjy.myapplication.R.layout
import com.dngwjy.myapplication.data.MenuMakananModel
import com.dngwjy.myapplication.data.MenuMinumanModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_menu.iv_mie
import kotlinx.android.synthetic.main.item_list_menu.tv_harga
import kotlinx.android.synthetic.main.item_list_menu.tv_mie

/**
 * Created by wijaya on 29/09/19
 */
class RvAdapterMinuman(private val data:List<MenuMinumanModel>) :
    RecyclerView.Adapter<RvAdapterMinuman.MenuViewHolder>() {

    override fun onCreateViewHolder
                (parent: ViewGroup, viewType: Int)
            : MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    layout.item_list_menu,
                    parent, false
                )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MenuViewHolder(
        override val containerView: View
    )
        : RecyclerView.ViewHolder(containerView)
        , LayoutContainer
    {
        fun bindData(item: MenuMinumanModel){
            tv_mie.text=item.namaMenu
            tv_harga.text=item.hargaMenu
            Glide.with(containerView)
                .load(item.gambarMenu)
                .into(iv_mie)

            itemView.setOnClickListener {
                Toast.makeText(containerView.context,
                    item.namaMenu, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}