package com.lyw.tauren.data.model.been

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 功能描述:文章数据类
 * Created on 2021/1/7.
 * @author lyw
 * //使用Kotlin实验特性（不加实体数据类会报“X类不是抽象的，并且没有实现android.os.Parcelable中定义的有趣的writeToParcel（）(Class X is not abstract and does not implement fun writeToParcel() defined in android.os.Parcelable)”异常）
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class AriticleResponse(
    var apkLink: String,
    var author: String,//作者
    var chapterId: Int,
    var chapterName: String,
    var collect: Boolean,//是否收藏
    var courseId: Int,
    var desc: String,
    var envelopePic: String,
    var fresh: Boolean,
    var id: Int,
    var link: String,
    var niceDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var superChapterId: Int,
    var superChapterName: String,
    var shareUser: String,
    var tags: List<TagsResponse>,
    var title: String,
    var type: Int,
    var userId: Int,
    var visible: Int,
    var zan: Int) : Parcelable