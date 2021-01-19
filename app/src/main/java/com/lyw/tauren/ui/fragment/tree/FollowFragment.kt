package com.lyw.tauren.ui.fragment.tree

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.tauren.data.model.been.Item
import com.lyw.tauren.ui.adapter.FollowAdapter
import com.lyw.tauren.viewmodel.state.FollowViewModel

/**
 * 功能描述:
 * Created on 2021/1/14.
 * @author lyw
 */
class FollowFragment :CommonListFragment<FollowViewModel,Item>(){
    override fun getAdapter(): BaseQuickAdapter<Item, BaseViewHolder> = FollowAdapter(mActivity)
}