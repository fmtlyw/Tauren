package com.lyw.module_player.observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import cn.jzvd.Jzvd


/**
 * 功能描述:
 * Created on 2021/1/22.
 * @author lyw
 */
class JZVDObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_PAUSE) {
            Jzvd.releaseAllVideos()
        }
    }
}