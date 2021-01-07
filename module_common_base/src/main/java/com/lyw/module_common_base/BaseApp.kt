package com.lyw.module_common_base

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.multidex.MultiDex
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.lyw.module_common_base.callback.loadCallBack.EmptyCallback
import com.lyw.module_common_base.callback.loadCallBack.ErrorCallback
import com.lyw.module_common_base.callback.loadCallBack.LoadingCallback
import com.tencent.mmkv.MMKV

/**
 * 功能描述:
 * Created on 2020/12/17.
 * @author lyw
 */
open class BaseApp : Application(), ViewModelStoreOwner {

    private var mFactory: ViewModelProvider.Factory? = null
    private lateinit var mAppViewModelStore: ViewModelStore
    //静态函数，相当于java static final
    companion object{
        //延迟初始化
        lateinit var appContext : BaseApp
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        mAppViewModelStore = ViewModelStore()
        //初始化MMKV（代替SP）
        MMKV.initialize(this.filesDir.absolutePath + "/mmkv")

        //分包
        MultiDex.install(this)

        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()
    }

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }

    /**
     * 获取一个全局的ViewModel
     */
    fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory as ViewModelProvider.Factory
    }
}