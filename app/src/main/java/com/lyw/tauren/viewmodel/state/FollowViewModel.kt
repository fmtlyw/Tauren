package com.lyw.tauren.viewmodel.state

import com.lyw.tauren.ui.fragment.tree.service.DiscoverService

/**
 * 功能描述:
 * Created on 2021/1/15.
 * @author lyw
 */
class FollowViewModel : CommonListViewModel() {
    override suspend fun <M> getRefreshList(): List<M> {
        val followList = DiscoverService.getFollowList()
        mNextPageUrl = followList.nextPageUrl
        return followList.itemList as List<M>
    }

    override suspend fun <M> getLoadMoreList(): List<M> {
        val categoryDetailList = DiscoverService.getCategoryDetailList(mNextPageUrl!!)
        mNextPageUrl = categoryDetailList.nextPageUrl
        return categoryDetailList.itemList as List<M>
    }
}