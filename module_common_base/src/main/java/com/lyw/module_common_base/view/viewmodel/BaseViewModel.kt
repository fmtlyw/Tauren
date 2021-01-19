package com.lyw.module_common_base.view.viewmodel

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lyw.module_common_base.callback.livedata.EventLiveData
import java.lang.Exception

/**
 * 功能描述: ViewModel的基类 使用ViewModel类，放弃AndroidViewModel，原因：用处不大 完全有其他方式获取Application上下文
 * Created on 2020/12/20.
 * @author lyw
 */
open class BaseViewModel : ViewModel(){
    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    val mStateLiveData = MutableLiveData<State>()
    /**
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框 因为需要跟网络请求显示隐藏loading配套才加的，不然我加他个鸡儿加
     */
    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { EventLiveData<String>() }
        //隐藏
        val dismissDialog by lazy { EventLiveData<Boolean>() }
    }


    fun <T> liveDataEx(block: suspend LiveDataScope<T>.() -> T) = liveData {
        try {
            mStateLiveData.postValue(LoadState)
            emit(block())
            mStateLiveData.postValue(SuccessState)
        } catch (e: Exception) {
            mStateLiveData.postValue(ErrorState(e.message))
        }
    }
}

    sealed class State

    object LoadState : State()

    object SuccessState : State()

    class ErrorState(val errorMsg: String?) : State()
