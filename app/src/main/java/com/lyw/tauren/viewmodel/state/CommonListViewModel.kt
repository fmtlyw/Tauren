package com.lyw.tauren.viewmodel.state

import androidx.lifecycle.LiveData
import com.lyw.module_common_base.view.viewmodel.BaseViewModel

/**
 * 功能描述:
 * Created on 2021/1/14.
 * @author lyw
 */
abstract class CommonListViewModel : BaseViewModel() {
    var mNextPageUrl: String? = null
    fun <M> getListData(firstPage: Boolean): LiveData<List<M>> = liveDataEx {
        if (mNextPageUrl == null && !firstPage) {
            mutableListOf()
        } else {
            if (firstPage) {
                getRefreshList()
            } else {
                getLoadMoreList()
            }
        }
    }

    abstract suspend fun <M> getRefreshList(): List<M>

    abstract suspend fun <M> getLoadMoreList(): List<M>
}