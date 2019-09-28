package com.dngwjy.myapplication.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dngwjy.myapplication.R
import com.dngwjy.myapplication.data.MenuMakananModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_menu.iv_mie
import kotlinx.android.synthetic.main.item_list_menu.tv_harga
import kotlinx.android.synthetic.main.item_list_menu.tv_mie

/**
 * Created by wijaya on 28/09/19
 */
class RvAdapter(private val data:List<MenuMakananModel>) :
    RecyclerView.Adapter<RvAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder
                (parent: ViewGroup, viewType: Int)
            : MenuViewHolder {
       return MenuViewHolder(LayoutInflater
           .from(parent.context)
           .inflate(R.layout.item_list_menu,
               parent,false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MenuViewHolder(
        override val containerView: View)
        :RecyclerView.ViewHolder(containerView)
        ,LayoutContainer
    {
        fun bindData(item:MenuMakananModel){
            tv_mie.text=item.namaMenu
            tv_harga.text=item.hargaMenu
            iv_mie.setImageResource(item.gambarMenu)

            itemView.setOnClickListener {
                Toast.makeText(containerView.context,
                    item.namaMenu,Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}