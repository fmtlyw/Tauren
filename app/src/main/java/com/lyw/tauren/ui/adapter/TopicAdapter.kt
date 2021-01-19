package com.lyw.tauren.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.TopicItemModel
import com.lyw.tauren.databinding.ItemDiscoverTopicBinding

/**
 * 功能描述:主题adapter
 * Created on 2021/1/19.
 * @author lyw
 */
class TopicAdapter :BaseQuickAdapter<TopicItemModel, BaseViewHolder>(R.layout.item_discover_topic),LoadMoreModule{
    override fun convert(holder: BaseViewHolder, item: TopicItemModel) {
        val bindingHolder = BaseDataBindingHolder<ItemDiscoverTopicBinding>(holder.itemView)
        bindingHolder.dataBinding?.model = item
    }
}