package com.lyw.tauren.ui.fragment.search

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentSearchBinding
import com.lyw.tauren.viewmodel.state.SearchViewModel

/**
 * 功能描述:搜索fragment
 * Created on 2021/1/5.
 * @author lyw
 */
class SearchFragment :BaseFragment<SearchViewModel,FragmentSearchBinding>(){
    override fun layoutId(): Int = R.layout.fragment_search

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
    override fun lazyLoadData() {
    }

    override fun showLoading(message: String) {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }
}