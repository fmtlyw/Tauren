package com.lyw.tauren.ui.fragment.tree

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentTreeArrBinding
import com.lyw.tauren.viewmodel.state.TreeArrViewModel

/**
 * 功能描述:广场fragment
 * Created on 2021/1/5.
 * @author lyw
 */
class TreeArrFragment : BaseFragment<TreeArrViewModel,FragmentTreeArrBinding>(){
    override fun layoutId(): Int = R.layout.fragment_tree_arr

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
    override fun lazyLoadData() {
    }
}