package com.lyw.tauren.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.blankj.utilcode.util.ConvertUtils
import com.kingja.loadsir.core.LoadService
import com.lyw.module_common_base.ext.nav
import com.lyw.module_common_base.ext.navigateAction
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.module_common_base.view.viewmodel.parseState
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.BannerResponse
import com.lyw.tauren.databinding.FragmentHomeBinding
import com.lyw.tauren.ext.*
import com.lyw.tauren.ui.adapter.AriticleAdapter
import com.lyw.tauren.viewmodel.request.RequestHomeViewModel
import com.lyw.tauren.viewmodel.state.HomeViewModel
import com.lyw.tauren.weight.banner.HomeBannerAdapter
import com.lyw.tauren.weight.banner.HomeBannerViewHolder
import com.lyw.tauren.weight.recyclerview.SpaceItemDecoration
import com.zhpan.bannerview.BannerViewPager
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

    //请求数据ViewModel
    private val requestHomeViewModel: RequestHomeViewModel by viewModels()//备注：by viewModels()下划线红色，原因：build文件没有加jvmTarget = "1.8"


    //界面状态管理者
    private lateinit var loadSir: LoadService<Any>

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initView(savedInstanceState: Bundle?) {
        //状态页设置
        loadSir = loadServiceInit(swipeRefresh) {
            //点击重试时触发的操作
            loadSir.showLoading()
            requestHomeViewModel.getBannerData()
            requestHomeViewModel.getHomeData(true)
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
        swipeRefresh.init {
            //触发刷新监听时请求数据
            requestHomeViewModel.getHomeData(true)
        }


        articleAdapter.run {
            //收藏点击
            //item点击

        }
    }

    override fun createObserver() {
        requestHomeViewModel.run {
            homeDataState.observe(viewLifecycleOwner, Observer {
                //设值,用拓展函数
                loadListData(it,articleAdapter,loadSir,recyclerView,swipeRefresh)
            })
            //监听轮播图请求的数据变化
            bannerData.observe(viewLifecycleOwner, Observer { resultState ->
                parseState(resultState, { data ->
                    //请求轮播图数据成功，添加轮播图到headview ，如果等于0说明没有添加过头部，添加一个
                    if (recyclerView.headerCount == 0) {
                        val headView = LayoutInflater.from(context).inflate(R.layout.include_banner, null)
                                .apply {
                                    findViewById<BannerViewPager<BannerResponse, HomeBannerViewHolder>>(
                                        R.id.banner_view
                                    ).apply {
                                        adapter = HomeBannerAdapter()
                                        setLifecycleRegistry(lifecycle)//为啥在这设置
                                        setOnPageClickListener {
//                                    nav().navigateAction()

                                        }
                                        create(data)
                                    }
                                }
                        recyclerView.addHeaderView(headView)
                        recyclerView.scrollToPosition(0)
                    }

                })
            })
        }

    }

    override fun lazyLoadData() {
        //设置界面 加载中
        loadSir.showLoading()
        //请求首页列表数据
        requestHomeViewModel.getHomeData(true)
        //请求轮播图数据
        requestHomeViewModel.getBannerData()
    }
}