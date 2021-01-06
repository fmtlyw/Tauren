package com.lyw.tauren.ui.fragment.home

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentHomeBinding
import com.lyw.tauren.viewmodel.state.HomeViewModel

/**
 * 功能描述:首页
 * Created on 2020/12/29.
 * @author lyw
 */
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>(){
    override fun layoutId(): Int = R.layout.fragment_home

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
}