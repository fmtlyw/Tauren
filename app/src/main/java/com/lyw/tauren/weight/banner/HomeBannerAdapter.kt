package com.lyw.tauren.weight.banner

import android.view.View
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.BannerResponse
import com.zhpan.bannerview.BaseBannerAdapter

/**
 * 功能描述:轮播图适配器
 * Created on 2021/1/8.
 * @author lyw
 */
class HomeBannerAdapter :BaseBannerAdapter<BannerResponse,HomeBannerViewHolder>() {
    override fun getLayoutId(viewType: Int) = R.layout.banner_itemhome

    override fun createViewHolder(itemView: View, viewType: Int): HomeBannerViewHolder {
      return HomeBannerViewHolder(itemView)
    }

    override fun onBind(
        holder: HomeBannerViewHolder?,
        data: BannerResponse?,
        position: Int,
        pageSize: Int
    ) {
       holder?.bindData(data,position,pageSize)
    }
}