package com.lyw.tauren.ui.fragment.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.lyw.module_common_base.ext.nav
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.TodoResponse
import com.lyw.tauren.databinding.FragmentAddTodoBinding
import com.lyw.tauren.ext.initClose
import com.lyw.tauren.ext.showMessage
import com.lyw.tauren.util.DatetimeUtil
import com.lyw.tauren.viewmodel.request.RequestToDoViewModel
import com.lyw.tauren.viewmodel.state.AddTodoViewModel
import kotlinx.android.synthetic.main.include_toolbar.*
import java.util.*

/**
 * 功能描述:
 * Created on 2021/2/3.
 * @author lyw
 */
class AddTodoFragment : BaseFragment<AddTodoViewModel, FragmentAddTodoBinding>() {

    private var todoResponse: TodoResponse? = null

    private val requestViewModel: RequestToDoViewModel by viewModels()


    override fun layoutId(): Int = R.layout.fragment_add_todo

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.model = mViewModel
        mDatabind.click = ProxyClick()

        toolBar.initClose(if (todoResponse == null) "添加TODO" else "修改TODO") {
            nav().navigateUp()
        }
    }

    override fun createObserver() {
    }

    override fun lazyLoadData() {
    }


    inner class ProxyClick {
        /** 选择时间*/
        fun selectDate() {
            Log.d("lyw","点击了时间选择")
            activity?.let {
                MaterialDialog(it).lifecycleOwner(this@AddTodoFragment).show {
                    cornerRadius(0f)
                    datePicker(minDate = Calendar.getInstance()) { dialog, datetime ->
                        mViewModel.todoTime =
                            DatetimeUtil.formatDate(datetime.time, DatetimeUtil.DATE_PATTERN)
                    }
                }
            }
        }

        /** 选择类型*/
        fun selectTpye() {

        }

        /** 提交*/
        fun submit() {
            when {
                mViewModel.todoTitle.isEmpty() -> {
                    showMessage("请填写标题")
                }
                mViewModel.todoContent.isEmpty() -> {
                    showMessage("请填写内容")
                }
                mViewModel.todoTime.isEmpty() -> {
                    showMessage("请选择预计完成时间")
                }
                else -> {

                }
            }
        }

    }
}