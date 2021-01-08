package com.lyw.tauren.data.model.been

import com.lyw.module_common_base.network.BaseResponse

/**
 * 功能描述:服务器返回数据的基类
 * Created on 2021/1/7.
 * @author lyw
 * 实现逻辑：
 * 1.继承 BaseResponse
 * 2.重写isSucces 方法，编写你的业务需求，根据自己的条件判断数据是否请求成功
 * 3.重写 getResponseCode、getResponseData、getResponseMsg方法，传入你的 code data msg
 */
data class ApiResponse<T>(val errorCode:Int,val errorMsg:String ,val data:T):BaseResponse<T>() {
    // 这里是示例，wanandroid 网站返回的 错误码为 0 就代表请求成功，请你根据自己的业务需求来改变
    override fun isSucces() = errorCode ==0

    override fun getResponseData() = data

    override fun getResponseCode() = errorCode

    override fun getResponseMsg() = errorMsg
}