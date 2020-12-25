package com.lyw.module_common_base

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.multidex.MultiDex
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