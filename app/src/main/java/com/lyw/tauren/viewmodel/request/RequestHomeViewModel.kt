package com.lyw.tauren.viewmodel.request

import androidx.lifecycle.MutableLiveData
import com.lyw.module_common_base.network.ResultState
import com.lyw.module_common_base.view.viewmodel.BaseViewModel
import com.lyw.module_common_base.view.viewmodel.request
import com.lyw.tauren.data.model.been.AriticleResponse
import com.lyw.tauren.data.model.been.BannerResponse
import com.lyw.tauren.data.repository.request.HttpRequestCoroutine
import com.lyw.tauren.network.apiService
import com.lyw.tauren.network.stateCallback.ListDataUiState

/**
 * 功能描述:首页的数据和banner获取
 * Created on 2021/1/7.
 * @author lyw
 * 有两种回调方式：
 *1.首页文章列表 将返回的数据放在ViewModel中过滤包装给activity/fragment去使用
 *2.首页轮播图 将返回的数据直接给activity/fragment去处理使用
 * 可以根据个人理解与喜好使用(建议 简单的不需要做数据过滤包装的能直接用返回数据的可以直接用2   复杂的需要自己封装一下让使用变的更方便的可以使用1  )
 */
class RequestHomeViewModel : BaseViewModel() {
    //页码 首页数据页码从0开始
    var pageNo = 0

    //首页文章列表数据
    var homeDataState: MutableLiveData<ListDataUiState<AriticleResponse>> = MutableLiveData()

    //首页轮播图数据
    var bannerData: MutableLiveData<ResultState<ArrayList<BannerResponse>>> = MutableLiveData()

    fun getHomeData(isRefresh: Boolean) {
        if (isRefresh) {
            pageNo = 0
        }
        request({ HttpRequestCoroutine.getHomeData(pageNo) }, {
            //请求成功
            pageNo++
            val listDataUiState = ListDataUiState(
                isSuccess = true,
                isRefresh = isRefresh,
                isEmpty = it.isEmpty(),
                hasMore = it.hasMore(),
                isFirstEmpty = isRefresh && it.isEmpty(),
                listData = it.datas
            )
            homeDataState.value = listDataUiState
        }, {
            //请求失败
            val listDataUiState = ListDataUiState(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = isRefresh,
                listData = arrayListOf<AriticleResponse>()
            )
            homeDataState.value = listDataUiState
        })
    }

    /**
     * 获取轮播图数据
     */
    fun getBannerData() {
        request({ apiService.getBanner() }, bannerData)
    }
}
