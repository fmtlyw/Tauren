package com.lyw.module_common_base.callback.loadCallBack

import com.kingja.loadsir.callback.Callback
import com.lyw.module_common_base.R

/**
 * 功能描述:
 * Created on 2021/1/6.
 * @author lyw
 */
class EmptyCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }

}