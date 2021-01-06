package com.lyw.tauren.ui.fragment

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentMainBinding
import com.lyw.tauren.ext.init
import com.lyw.tauren.ext.initMain
import com.lyw.tauren.ext.interceptLongClick
import com.lyw.tauren.viewmodel.state.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * 功能描述:
 * Created on 2021/1/5.
 * @author lyw
 */
class MainFragment :BaseFragment<MainViewModel,FragmentMainBinding>(){
    override fun layoutId(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        //初始化viewpager2
        mainViewpager.initMain(this)
        //初始化 bottomBar
        mainBottom.init{
            when (it){
                R.id.menu_main -> mainViewpager.setCurrentItem(0,false)
                R.id.menu_project -> mainViewpager.setCurrentItem(1,false)
                R.id.menu_system -> mainViewpager.setCurrentItem(2,false)
                R.id.menu_public -> mainViewpager.setCurrentItem(3,false)
                R.id.menu_me -> mainViewpager.setCurrentItem(4,false)
            }
        }
        //防止长按时出现Toast
        mainBottom.interceptLongClick(R.id.menu_main,R.id.menu_project,R.id.menu_system,R.id.menu_public,R.id.menu_me)

    }

    override fun createObserver() {
    }
}