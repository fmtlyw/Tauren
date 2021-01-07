package com.lyw.tauren.data.model.been

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 功能描述:文章的标签
 * Created on 2021/1/7.
 * @author lyw
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class TagsResponse(var name:String, var url:String): Parcelable