package com.lyw.tauren.ui.fragment.tree.service

import com.lyw.module_http.RetrofitClient
import com.lyw.tauren.ui.fragment.tree.api.DiscoverApi

/**
 * 功能描述:发现访问网络接口
 * Created on 2021/1/18.
 * @author lyw
 */
object DiscoverService : DiscoverApi by RetrofitClient.instance.create(DiscoverApi::class.java)