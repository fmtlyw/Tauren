package com.lyw.tauren.viewmodel.state

import com.lyw.tauren.ui.fragment.tree.service.DiscoverService

/**
 * 功能描述:专题ViewModel
 * Created on 2021/1/19.
 * @author lyw
 */
class TopicViewModel : CommonListViewModel(){
    override suspend fun <M> getRefreshList(): List<M> {
        val topicList = DiscoverService.getTopicList()
        mNextPageUrl = topicList.nextPageUrl
        return topicList.itemList as List<M>
    }

    override suspend fun <M> getLoadMoreList(): List<M> {
        val topicList = DiscoverService.getTopicList(mNextPageUrl!!)
        mNextPageUrl = topicList.nextPageUrl
        return topicList.itemList as List<M>
    }
}