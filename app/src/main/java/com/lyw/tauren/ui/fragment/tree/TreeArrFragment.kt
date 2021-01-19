package com.lyw.tauren.ui.fragment.tree

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentTreeArrBinding
import com.lyw.tauren.viewmodel.state.TreeArrViewModel
import kotlinx.android.synthetic.main.fragment_tree_arr.*
import java.util.*

/**
 * 功能描述:发现fragment
 * Created on 2021/1/5.
 * @author lyw
 */
class TreeArrFragment : BaseFragment<TreeArrViewModel, FragmentTreeArrBinding>() {
    private val mTabTitleList: Array<String> by lazy { resources.getStringArray(R.array.discover_titles) }

    private val mFragmentList by lazy {
        mutableListOf<Fragment>().apply {
            add(FollowFragment())
            add(FollowFragment())
            add(FollowFragment())
            add(FollowFragment())
        }
    }


    override fun layoutId(): Int = R.layout.fragment_tree_arr

    override fun initView(savedInstanceState: Bundle?) {
        //如果ViewPage2这里需要处理两种冲突：
        //1.横向RecyclerView与ViewPage2的滑动冲突
        //2.垂直方向RecyclerView与横向RecyclerView的滑动冲突
        //比较麻烦，所以此处采用了ViewPager
        mViewPager.adapter = object :
            FragmentStatePagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment  = mFragmentList[position]

            override fun getCount(): Int = mTabTitleList.size

            override fun getPageTitle(position: Int): CharSequence? = mTabTitleList[position]
        }
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun createObserver() {
    }

    override fun lazyLoadData() {
    }
}