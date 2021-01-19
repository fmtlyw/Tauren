package com.lyw.module_http

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 功能描述:静态内部类方式实现单例模式
 * Created on 2021/1/14.
 * @author lyw
 */
class RetrofitClient private constructor() {
    private val TAG = RetrofitClient::class.java.simpleName


    companion object {
        val instance = SingleTonProvider.holder
    }

    private object SingleTonProvider {
        val holder = RetrofitClient()
    }


    private val okHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Configurator.instance.getConfiguration<String>(ConfigKeys.WEB_API_HOST))
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(service: Class<T>): T {
        Log.d("lyw","baseUrl-->"+Configurator.instance.getConfiguration<String>(ConfigKeys.WEB_API_HOST))
        return retrofit.create(service)
    }
}