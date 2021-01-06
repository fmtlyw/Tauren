package com.lyw.module_common_base.view.fragment

import androidx.databinding.ViewDataBinding
import com.lyw.module_common_base.ext.getAppViewModel
import com.lyw.module_common_base.view.viewmodel.AppViewModel
import com.lyw.module_common_base.view.viewmodel.BaseViewModel
import com.lyw.module_common_base.view.viewmodel.EventViewModel

/**
 * 功能描述:你项目中的Fragment基类，在这里实现显示弹窗，吐司，还有自己的需求操作 ，如果不想用Databind，请继承
 * BaseVmFragment例如
 * abstract class BaseFragment<VM : BaseViewModel> : BaseVmFragment<VM>() {
 * Created on 2021/1/5.
 * @author lyw
 */
abstract class BaseFragment<VM : BaseViewModel,DB : ViewDataBinding> :BaseVmDbFragment<VM,DB>(){

    //Application全局的ViewModel，里面存放了一些账户信息，基本配置信息等
    val appViewModel: AppViewModel by lazy { getAppViewModel<AppViewModel>() }


    //Application全局的ViewModel，用于发送全局通知操作
    val eventViewModel: EventViewModel by lazy { getAppViewModel<EventViewModel>() }
}