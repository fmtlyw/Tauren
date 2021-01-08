package com.lyw.tauren.data.repository.request

import com.lyw.tauren.data.model.been.ApiPagerResponse
import com.lyw.tauren.data.model.been.ApiResponse
import com.lyw.tauren.data.model.been.AriticleResponse
import com.lyw.tauren.network.apiService
import com.lyw.tauren.util.CacheUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

/**
 * 功能描述:处理协程的请求类
 * Created on 2021/1/7.
 * @author lyw
 */

val HttpRequestCoroutine :HttpRequestManger by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    HttpRequestManger()
}

class HttpRequestManger {
    /**
     * 获取首页文章数据
     */
    suspend fun getHomeData(pageNo: Int): ApiResponse<ApiPagerResponse<ArrayList<AriticleResponse>>> {
        return withContext(Dispatchers.IO) {
            val data = async { apiService.getAritrilList(pageNo) }
            //如果App配置打开了首页请求置顶文章，且是第一页
            if (CacheUtil.isNeedTop() && pageNo == 0) {
                val topData = async { apiService.getTopAritrilList() }
                data.await().data.datas.addAll(0, topData.await().data)
                data.await()
            } else {
                data.await()
            }
        }
    }
}