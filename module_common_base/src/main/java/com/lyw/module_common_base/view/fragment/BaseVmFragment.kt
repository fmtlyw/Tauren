package com.lyw.module_common_base.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lyw.module_common_base.ext.errorToast
import com.lyw.module_common_base.ext.getVmClazz
import com.lyw.module_common_base.view.viewmodel.BaseViewModel
import com.lyw.module_common_base.view.viewmodel.ErrorState
import com.lyw.module_common_base.view.viewmodel.LoadState
import com.lyw.module_common_base.view.viewmodel.SuccessState

/**
 * 功能描述:ViewModelFragment基类，自动把ViewModel注入Fragment
 * Created on 2021/1/5.
 * @author lyw
 */
abstract class BaseVmFragment<VM : BaseViewModel> : Fragment() {
    //是否第一次加载
    private var isFirst: Boolean = true
    lateinit var mViewModel: VM

    lateinit var mActivity: AppCompatActivity

    abstract fun layoutId(): Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()
        isFirst = true
        initView(savedInstanceState)
        createObserver()
        initData()

        initViewModel()
    }

    private fun initViewModel() {
        mViewModel.mStateLiveData.observe(viewLifecycleOwner, Observer {state ->
            when (state) {
                LoadState -> {
                    showLoading()
                }
                SuccessState -> {
                    hideLoading()
                }
                is ErrorState -> {
                    hideLoading()
                    state.errorMsg?.let { errorToast(it) }
                    handlerError()
                    Log.d("lyw","initViewModel--错误信息----》" + state.errorMsg)
                }
            }
        })
    }

    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    /**
     * 初始化view
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 创建观察者
     */
    abstract fun createObserver()

    abstract fun showLoading(message: String = "请求网络中...")

    abstract fun dismissLoading()

    /**
     * Fragment执行onCreate后触发的方法
     */
    open fun initData() {}


    override fun onResume() {
        super.onResume()
        onVisible()
    }

    /**
     * 是否需要懒加载
     */
    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
//等待view加载后触发懒加载
            view?.post {
                lazyLoadData()

                isFirst = false
            }
        }
    }

    /**
     * 懒加载
     */
    abstract fun lazyLoadData()



    //由于每个页面的加载框可能不一致，所以此处暴露给子类实现
    open fun showLoading() {

    }

    open fun hideLoading() {

    }

    open fun handlerError() {

    }
}