package com.lyw.tauren.ui.fragment.collect

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentCollectBinding
import com.lyw.tauren.viewmodel.state.CollectViewModel

/**
 * 功能描述:收藏fragment
 * Created on 2021/1/5.
 * @author lyw
 */
class CollectFragment : BaseFragment<CollectViewModel,FragmentCollectBinding>(){
    override fun layoutId(): Int = R.layout.fragment_collect

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }

    override fun lazyLoadData() {
    }
}