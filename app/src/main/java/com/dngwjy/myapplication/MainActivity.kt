package com.dngwjy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.tabs_main
import kotlinx.android.synthetic.main.activity_main.viewpager_main

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter=ViewPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
    }


    //class untuk adapter viewpager
    inner class ViewPagerAdapter(fm: FragmentManager)
        : FragmentPagerAdapter(fm){
        // sebuah list yang menampung objek Fragment
        //asdasfaqw
        private val pages = listOf(
            MakananFragment.getInstance(),
            MinumanFragment.getInstance()
        )
        // menentukan fragment yang akan dibuka pada posisi tertentu
        override fun getItem(position: Int): Fragment {
            return pages[position]
        }
        override fun getCount(): Int {
            return pages.size
        }
        // judul untuk tabs
        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0 -> "Makanan"
                else -> "Minumam"
            }
        }
    }
}
