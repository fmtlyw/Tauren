package com.lyw.tauren.ui.fragment.tree

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.module_common_base.view.fragment.BaseVmFragment
import com.lyw.tauren.R
import com.lyw.tauren.viewmodel.state.CommonListViewModel
import kotlinx.android.synthetic.main.fragment_discover_common_refresh.*

/**
 * 功能描述:发现界面基类Fragment
 * Created on 2021/1/14.
 * @author lyw
 */
abstract class CommonListFragment<VM : CommonListViewModel, M> : BaseVmFragment<VM>(),
    OnItemClickListener {

    private var mIsLoadMore = false

    override fun layoutId() = R.layout.fragment_discover_common_refresh

    lateinit var mAdapter: BaseQuickAdapter<M, BaseViewHolder>

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isRefreshing = true
        mSwipeRefreshLayout.setOnRefreshListener {
            lazyLoadData()
        }

        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = getAdapter()
        mAdapter.setOnItemClickListener(this)
        mAdapter.loadMoreModule.setOnLoadMoreListener {
            mIsLoadMore = true
            getListData()
        }
        mRecyclerView.adapter = mAdapter

    }

    private fun getListData(firstPage: Boolean = false) {
        mViewModel.getListData<M>(firstPage).observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                if (firstPage) {
                    mAdapter.setList(it)
                } else {
                    mAdapter.addData(it)
                    mAdapter.loadMoreModule.loadMoreComplete()
                }
            } else {
                if (mViewModel.mNextPageUrl == null) {
                    mAdapter.loadMoreModule.loadMoreEnd()
                } else {
                    mAdapter.loadMoreModule.loadMoreComplete()
                }
            }
        })
    }

    override fun lazyLoadData() {
        getListData(true)
    }

    abstract fun getAdapter(): BaseQuickAdapter<M, BaseViewHolder>


    override fun createObserver() {
    }

    override fun showLoading(message: String) {
    }

    override fun dismissLoading() {
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
    }

    override fun hideLoading() {
        mSwipeRefreshLayout.isRefreshing = false
    }

    override fun handlerError() {
        if (mIsLoadMore) {
            mAdapter.loadMoreModule.loadMoreFail()
        }
    }
}