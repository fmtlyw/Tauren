package com.lyw.tauren.viewmodel.request

import androidx.lifecycle.MutableLiveData
import com.lyw.module_common_base.view.viewmodel.BaseViewModel
import com.lyw.module_common_base.view.viewmodel.request
import com.lyw.tauren.data.model.been.TodoResponse
import com.lyw.tauren.network.apiService
import com.lyw.tauren.network.stateCallback.ListDataUiState

/**
 * 功能描述:
 * Created on 2021/1/29.
 * @author lyw
 */
class RequestToDoViewModel : BaseViewModel() {

    var pageNo = 1


    //列表集合数据
    var todoDataState = MutableLiveData<ListDataUiState<TodoResponse>>()


    fun getTodoData(isRefresh: Boolean) {
        if (isRefresh) {
            pageNo = 1
        }
        request({apiService.getTodoData(pageNo)},{
            //请求成功
            pageNo ++
            val listDataUiState = ListDataUiState(
                isSuccess = true,
                isRefresh = isRefresh,
                isEmpty = it.isEmpty(),
                hasMore = it.hasMore(),
                isFirstEmpty = isRefresh && it.isEmpty(),
                listData = it.datas
            )
            todoDataState.value = listDataUiState
        },{
            //失败
            val listDataUiState = ListDataUiState(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = arrayListOf<TodoResponse>()
            )
            todoDataState.value = listDataUiState
        })
    }
}