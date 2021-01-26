package com.lyw.module_player.activity

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import cn.jzvd.Jzvd
import cn.jzvd.JzvdStd
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lyw.module_common_base.ext.fromJson
import com.lyw.module_common_base.ext.immersionStatusBar
import com.lyw.module_common_base.view.activity.BaseActivity
import com.lyw.module_player.R
import com.lyw.module_player.databinding.ActivityPlayerVideoBinding
import com.lyw.module_player.observer.JZVDObserver
import com.lyw.module_player.viewmodel.VideoPlayerViewModel
import com.lyw.module_provider.constant.BaseConstant
import com.lyw.module_provider.model.Data
import com.lyw.module_provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_player_video.*

/**
 * 功能描述:视频播放activity
 * Created on 2021/1/21.
 * @author lyw
 */
@Route(path = RouterPath.Video.PATH_VIDEO_HOME)
class VideoPlayerActivity : BaseActivity<VideoPlayerViewModel, ActivityPlayerVideoBinding>() {

    @JvmField
    @Autowired(name = BaseConstant.VIDEO_MODE_KEY)
    var videoModelJSON: String = ""

    @JvmField
    @Autowired(name = BaseConstant.VIDEO_IS_FROM_RELATE_KEY)
    var fromRelate: Boolean = false

    private lateinit var videoModel: Data


    override fun layoutId(): Int = R.layout.activity_player_video

    override fun initView(savedInstanceState: Bundle?) {
        immersionStatusBar()
    }

    override fun showLoading(message: String) {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }

    override fun createObserver() {
        ARouter.getInstance().inject(this)
        videoModel = fromJson(videoModelJSON)
        mDataBind.videomodel = videoModel


        addNormalVideoView()
        //监听播放状态，界面退出，视频暂停播放
        lifecycle.addObserver(JZVDObserver())
    }

    //注：viewTreeObserver：View的变化监听    先写object :再按alt+enter会弹出实现方法onPreDraw()
    private fun addNormalVideoView() {
        mSurfaceContainer.viewTreeObserver.addOnPreDrawListener(object :
            ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                mSurfaceContainer.viewTreeObserver.removeOnPreDrawListener(this)
                val jzvdStd = JzvdStd(this@VideoPlayerActivity).apply {
                    setUp(videoModel.playUrl, videoModel.title)
                    startVideo()
                }
                mSurfaceContainer.addView(jzvdStd,FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                ))
                return true
            }
        })
    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }
}