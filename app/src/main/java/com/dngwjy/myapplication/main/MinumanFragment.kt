package com.dngwjy.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dngwjy.myapplication.R.layout

/**
 * Created by wijaya on 22/09/19
 */
class MinumanFragment :Fragment() {

    companion object{
        fun getInstance(): MinumanFragment {
            return MinumanFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.minuman_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}