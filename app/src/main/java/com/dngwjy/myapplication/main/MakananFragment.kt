package com.dngwjy.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dngwjy.myapplication.R.layout
import com.dngwjy.myapplication.adapter.RvAdapterMakanan
import com.dngwjy.myapplication.data.MenuDB
import com.dngwjy.myapplication.data.MenuDB.Companion
import com.dngwjy.myapplication.data.MenuMakananModel
import kotlinx.android.synthetic.main.makanan_fragment.rv_makanan

/**
 * Created by wijaya on 22/09/19
 */
class MakananFragment: Fragment() {

    companion object{
        fun getInstance(): MakananFragment {
            return MakananFragment()
        }
    }

    val dataMakanan= mutableListOf<MenuMakananModel>()
    val mRvAdapterMakanan= RvAdapterMakanan(dataMakanan)
    var db:MenuDB?=null

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            layout.makanan_fragment,
            container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter=mRvAdapterMakanan
        rv_makanan.layoutManager=
            LinearLayoutManager(context)

        db= MenuDB.getInstance(context!!)
        getMenuMakanan()
    }

    private fun getMenuMakanan(){
        db?.menuDao()?.ambilMenuMakanan()
            ?.observe(this, Observer {hasil->
                when(hasil.size==0){
                    true->{
                        Toast.makeText(
                            context,
                            "Data Makanan masih kosong",
                            Toast.LENGTH_SHORT).show()
                    }
                    false->{
                        dataMakanan.clear()
                        dataMakanan.addAll(hasil)
                        mRvAdapterMakanan
                            .notifyDataSetChanged()
                    }
                }

            })
    }


}