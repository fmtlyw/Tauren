package com.lyw.tauren.ui.fragment.me

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentMeBinding
import com.lyw.tauren.viewmodel.state.MeViewModel

/**
 * 功能描述:我的
 * Created on 2020/12/29.
 * @author lyw
 */
class MeFragment : BaseFragment<MeViewModel,FragmentMeBinding>(){
    override fun layoutId(): Int = R.layout.fragment_me
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
}