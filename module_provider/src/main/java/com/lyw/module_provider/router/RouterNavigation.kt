package com.lyw.module_provider.router

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import com.alibaba.android.arouter.launcher.ARouter
import com.lyw.module_common_base.ext.toJson
import com.lyw.module_provider.constant.BaseConstant
import com.lyw.module_provider.model.Data

/**
 * 功能描述:
 * Created on 2021/1/21.
 * @author lyw
 */
fun go2VideoPlayerActivity(
    activity: Activity,
    view: View?,
    data: Data,
    fromRelate: Boolean = false
) {
    ARouter.getInstance().build(RouterPath.Video.PATH_VIDEO_HOME)
        .also { postcard ->
            view?.let { shareView ->
                postcard.withOptionsCompat(
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, shareView, BaseConstant.SHARED_ELEMENT_NAME
                    )
                )
            }
        }
        .withString(BaseConstant.VIDEO_MODE_KEY, toJson(data))
        .withBoolean(BaseConstant.VIDEO_IS_FROM_RELATE_KEY,fromRelate)
        .navigation(activity)
}