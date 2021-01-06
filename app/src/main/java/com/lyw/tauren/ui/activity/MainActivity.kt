package com.lyw.tauren.ui.activity

import android.os.Bundle
import com.lyw.module_common_base.view.activity.BaseActivity
import com.lyw.tauren.R
import com.lyw.tauren.databinding.ActivityMainBinding
import com.lyw.tauren.viewmodel.state.MainViewModel

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {
    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun showLoading(message: String) {
    }

    override fun dismissLoading() {
    }

    override fun createObserver() {
    }

}
