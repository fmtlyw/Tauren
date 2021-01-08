package com.lyw.tauren.ui.fragment.publicNumber

import android.os.Bundle
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentPublicNumberBinding
import com.lyw.tauren.viewmodel.state.PublicNumberViewModel

/**
 * 功能描述:公众号fragment
 * Created on 2021/1/5.
 * @author lyw
 */
class PublicNumberFragment :BaseFragment<PublicNumberViewModel,FragmentPublicNumberBinding>() {
    override fun layoutId(): Int = R.layout.fragment_public_number

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
    override fun lazyLoadData() {
    }

    override fun showLoading(message: String) {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }
}