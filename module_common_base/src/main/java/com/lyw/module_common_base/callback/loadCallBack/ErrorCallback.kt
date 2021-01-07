package com.lyw.module_common_base.callback.loadCallBack

import com.kingja.loadsir.callback.Callback
import com.lyw.module_common_base.R


class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }

}