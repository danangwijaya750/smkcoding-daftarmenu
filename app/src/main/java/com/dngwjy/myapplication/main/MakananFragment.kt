package com.dngwjy.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dngwjy.myapplication.R
import com.dngwjy.myapplication.R.layout
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
    lateinit var rvAdapter:RvAdapter

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            layout.makanan_fragment,
            container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter=rvAdapter
        rv_makanan.layoutManager=
            LinearLayoutManager(context)

        addDummyData()
    }

    private fun addDummyData(){
        dataMakanan.add(MenuMakananModel(
                "Mie dok-dok",
                "Rp. 8.000",
                R.drawable.mie_dok
                ))
        dataMakanan.add(MenuMakananModel(
                "Nasi Telor",
                "Rp. 7.500",
                R.drawable.nasi_telor
            )
        )
        dataMakanan.add(MenuMakananModel(
                "Nasi Orak-arik",
                "Rp. 8000",
                R.drawable.orak_arik
            )
        )

        rvAdapter.notifyDataSetChanged()
    }
}