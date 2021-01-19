package com.lyw.tauren.ui.adapter

import android.app.Activity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ConvertUtils.dp2px
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.Item
import com.lyw.tauren.databinding.ItemDiscoverFollowBinding
import com.lyw.tauren.databinding.ItemDiscoverWorksBinding

/**
 * 功能描述:
 * Created on 2021/1/15.
 * @author lyw
 */
class FollowAdapter(private val mActivity: Activity) :
    BaseQuickAdapter<Item, BaseViewHolder>(R.layout.item_discover_follow), LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: Item) {
        val bindingHolder =
            BaseDataBindingHolder<ItemDiscoverFollowBinding>(holder.itemView)
        bindingHolder.dataBinding?.let {
            it.model = item
            it.activity = mActivity
        }
    }

    class FollowWorksAdapter(private val activity: Activity) :
        BaseQuickAdapter<Item, BaseViewHolder>(R.layout.item_discover_works) {

        override fun convert(holder: BaseViewHolder, item: Item) {
            val bindingHolder = BaseDataBindingHolder<ItemDiscoverWorksBinding>(holder.itemView)
            bindingHolder.dataBinding?.model = item
//            bindingHolder.dataBinding?.ivCover?.setOnClickListener {
//                go2VideoPlayerActivity(
//                    activity,
//                    it,
//                    item.data
//                )
//            }
            if (data.indexOf(item) == data.size - 1) {
                bindingHolder.dataBinding?.llCover?.setPadding(dp2px(15f), 0, dp2px(15f), 0)
            }
        }
    }
}

@BindingAdapter(value = ["dataList", "activity"])
fun RecyclerView.setHorizontallyData(dataList: List<Item>, activity: Activity) {
    layoutManager =
        object :
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
            override fun canScrollVertically(): Boolean = false
        }
    adapter = FollowAdapter.FollowWorksAdapter(activity).also { followAdapter ->
        followAdapter.addData(dataList)
    }
}