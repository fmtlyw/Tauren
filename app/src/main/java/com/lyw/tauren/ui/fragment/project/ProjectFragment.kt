package com.lyw.tauren.ui.fragment.project

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentProjectBinding
import com.lyw.tauren.viewmodel.state.ProjectViewModel

/**
 * 功能描述:
 * Created on 2021/1/5.
 * @author lyw
 */
class ProjectFragment :BaseFragment<ProjectViewModel,FragmentProjectBinding>(){
    override fun layoutId(): Int = R.layout.fragment_project

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
}