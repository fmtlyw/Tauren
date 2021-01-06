package com.lyw.module_common_base.view.activity

import androidx.databinding.ViewDataBinding
import com.lyw.module_common_base.ext.getAppViewModel
import com.lyw.module_common_base.view.viewmodel.AppViewModel
import com.lyw.module_common_base.view.viewmodel.BaseViewModel

/**
 * 功能描述:基类
 * Created on 2020/12/29.
 * @author lyw
 * 你项目中的Activity基类，在这里实现显示弹窗，吐司，还有加入自己的需求操作 ，如果不想用Databind，请继承
 * BaseVmActivity例如
 * abstract class BaseActivity<VM : BaseViewModel> : BaseVmActivity<VM>() {
 */
abstract class BaseActivity<VM : BaseViewModel,DB : ViewDataBinding> : BaseVmDbActivity<VM,DB>() {

    //Application全局的ViewModel，里面存放了一些账户信息，基本配置信息等
   val appViewModel : AppViewModel by lazy { getAppViewModel<AppViewModel>() }

}