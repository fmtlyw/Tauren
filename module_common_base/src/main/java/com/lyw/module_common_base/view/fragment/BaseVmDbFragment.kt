package com.lyw.module_common_base.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lyw.module_common_base.view.viewmodel.BaseViewModel

/**
 * 功能描述:ViewModelFragment基类，自动把ViewModel注入Fragment和Databind注入进来了
 * 需要使用Databind的清继承它
 * Created on 2021/1/5.
 * @author lyw
 */
abstract class BaseVmDbFragment<VM : BaseViewModel,DB : ViewDataBinding> : BaseVmFragment<VM>() {
    //该类绑定的ViewDataBinding
    lateinit var mDatabind: DB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDatabind =DataBindingUtil.inflate(inflater,layoutId(),container,false)
        mDatabind.lifecycleOwner = this
        return mDatabind.root
    }

}