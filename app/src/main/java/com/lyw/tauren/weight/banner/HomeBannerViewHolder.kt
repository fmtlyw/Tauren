package com.lyw.tauren.weight.banner

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.lyw.module_common_base.BaseApp.Companion.appContext
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.BannerResponse
import com.zhpan.bannerview.BaseViewHolder

/**
 * 功能描述:
 * Created on 2021/1/7.
 * @author lyw
 */
class HomeBannerViewHolder(view: View) : BaseViewHolder<BannerResponse>(view) {
    override fun bindData(data: BannerResponse?, position: Int, pageSize: Int) {
        val img = itemView.findViewById<ImageView>(R.id.bannerhome_img)
        data?.let {
            Glide.with(appContext)
                .load(it.imagePath)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(img)
        }
    }

}