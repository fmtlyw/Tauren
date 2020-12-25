package com.lyw.module_common_base.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lyw.module_common_base.view.viewmodel.BaseViewModel

/**
 * 功能描述:包含ViewModel 和Databind ViewModelActivity基类，把ViewModel 和Databind注入进来了
 * 需要使用Databind的请继承它
 * Created on 2020/12/20.
 * @author lyw
 */
abstract class BaseVmDbActivity<VM : BaseViewModel,DB : ViewDataBinding> : BaseVmActivity<VM>(){
    lateinit var mDataBind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    override fun initDataBind() {
        mDataBind = DataBindingUtil.setContentView(this,layoutId())
        mDataBind.lifecycleOwner = this
    }
}