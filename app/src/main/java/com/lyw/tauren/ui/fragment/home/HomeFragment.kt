package com.lyw.tauren.ui.fragment.home

import android.os.Bundle
import com.lyw.module_common_base.ext.nav
import com.lyw.module_common_base.ext.navigateAction
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentHomeBinding
import com.lyw.tauren.ext.init
import com.lyw.tauren.viewmodel.state.HomeViewModel
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * 功能描述:首页
 * Created on 2020/12/29.
 * @author lyw
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override fun layoutId(): Int = R.layout.fragment_home

    override fun initView(savedInstanceState: Bundle?) {
        //初始化 toolbar
        toolBar.run {
            init("首页")
            inflateMenu(R.menu.home_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.home_search -> nav().navigateAction(R.id.action_mainfragment_to_searchfragment)
                }
                true
            }
        }
    }

    override fun createObserver() {
    }
}