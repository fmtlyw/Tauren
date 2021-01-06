package com.lyw.module_common_base.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lyw.module_common_base.ext.getVmClazz
import com.lyw.module_common_base.view.viewmodel.BaseViewModel

/**
 * 功能描述:ViewModelFragment基类，自动把ViewModel注入Fragment
 * Created on 2021/1/5.
 * @author lyw
 */
abstract class BaseVmFragment<VM : BaseViewModel> : Fragment() {
    lateinit var mViewModel: VM

    lateinit var mActivity: AppCompatActivity

    abstract  fun layoutId() : Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(),container,false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()
        initView(savedInstanceState)
        createObserver()
        initData()
    }

    /**
     * 创建viewModel
     */
    private fun createViewModel() : VM{
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

    /**
     * Fragment执行onCreate后触发的方法
     */
    open fun initData() {}
}