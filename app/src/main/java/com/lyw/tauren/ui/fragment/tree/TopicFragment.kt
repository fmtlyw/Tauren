package com.lyw.tauren.ui.fragment.tree

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.tauren.data.model.been.TopicItemModel
import com.lyw.tauren.ui.adapter.TopicAdapter
import com.lyw.tauren.viewmodel.state.TopicViewModel

/**
 * 功能描述:专题fragment
 * Created on 2021/1/14.
 * @author lyw
 */
class TopicFragment : CommonListFragment<TopicViewModel,TopicItemModel>(){
    override fun getAdapter(): BaseQuickAdapter<TopicItemModel, BaseViewHolder> = TopicAdapter()

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        super.onItemClick(adapter, view, position)
    }
}