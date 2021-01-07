package com.lyw.tauren.ui.fragment.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.blankj.utilcode.util.ConvertUtils
import com.kingja.loadsir.core.LoadService
import com.lyw.module_common_base.ext.nav
import com.lyw.module_common_base.ext.navigateAction
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentHomeBinding
import com.lyw.tauren.ext.init
import com.lyw.tauren.ext.initFloatBtn
import com.lyw.tauren.ext.loadServiceInit
import com.lyw.tauren.ext.showLoading
import com.lyw.tauren.ui.adapter.AriticleAdapter
import com.lyw.tauren.viewmodel.state.HomeViewModel
import com.lyw.tauren.weight.recyclerview.SpaceItemDecoration
import kotlinx.android.synthetic.main.include_list.*
import kotlinx.android.synthetic.main.include_recyclerview.*
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * 功能描述:首页
 * Created on 2020/12/29.
 * @author lyw
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    //业务逻辑
    //1、initView通过viewmodel调用接口获取数据
    //2、createObserver创建观察，当有数据获取，通过loadListData设置数据到adapter


    private val articleAdapter: AriticleAdapter by lazy { AriticleAdapter(arrayListOf(), true) }

    //界面状态管理者
    private lateinit var loadSir: LoadService<Any>

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initView(savedInstanceState: Bundle?) {
        //状态页设置
        loadSir = loadServiceInit(swipeRefresh) {
            //点击重试时触发的操作
            loadSir.showLoading()
        }
        //初始化 toolbar(设置标题和搜索按钮)
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

        //初始化recyclerView
        recyclerView.init(LinearLayoutManager(context), articleAdapter).let {
            it.addItemDecoration(SpaceItemDecoration(0, ConvertUtils.dp2px(8f), false))

            it.initFloatBtn(floatbtn)
        }

        //初始化 SwipeRefreshLayout
        swipeRefresh.init{
            //收藏点击


        }


        articleAdapter.run {


        }

    }

    override fun createObserver() {
    }

    override fun lazyLoadData() {
        //设置界面 加载中
        loadSir.showLoading()
    }
}