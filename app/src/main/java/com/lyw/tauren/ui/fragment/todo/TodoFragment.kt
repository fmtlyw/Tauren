package com.lyw.tauren.ui.fragment.todo

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ConvertUtils
import com.kingja.loadsir.core.LoadService
import com.lyw.module_common_base.ext.nav
import com.lyw.module_common_base.ext.navigateAction
import com.lyw.module_common_base.view.fragment.BaseFragment
import com.lyw.tauren.R
import com.lyw.tauren.databinding.FragmentTodoListBinding
import com.lyw.tauren.ext.*
import com.lyw.tauren.ui.adapter.TodoAdapter
import com.lyw.tauren.viewmodel.request.RequestToDoViewModel
import com.lyw.tauren.viewmodel.state.TodoViewModel
import com.lyw.tauren.weight.recyclerview.SpaceItemDecoration
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import kotlinx.android.synthetic.main.fragment_discover_common_refresh.*
import kotlinx.android.synthetic.main.include_recyclerview.*
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * 功能描述:
 * Created on 2021/1/29.
 * @author lyw
 */
class TodoFragment : BaseFragment<TodoViewModel, FragmentTodoListBinding>() {

    private val todoAdapter: TodoAdapter by lazy { TodoAdapter(arrayListOf()) }

    private val requestTodoViewModel : RequestToDoViewModel by viewModels()

    private lateinit var loadSir: LoadService<Any>

    override fun layoutId(): Int = R.layout.fragment_todo_list

    override fun initView(savedInstanceState: Bundle?) {
        toolBar.run {
            initClose("TODO") {
                nav().navigateUp()

            }
            inflateMenu(R.menu.todo_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.todo_add -> {
                        nav().navigateAction(R.id.action_todoListFragment_to_addTodoFragment)
                    }
                }
                true
            }
        }
        //状态页配置 swipeRefresh参数表示你要包裹的布局
        loadSir = loadServiceInit(swipeRefresh){
            loadSir.showLoading()
            requestTodoViewModel.getTodoData(true)
        }

        recyclerView.init(LinearLayoutManager(context),todoAdapter).let {
            it.addItemDecoration(SpaceItemDecoration(0,ConvertUtils.dp2px(8f)))
            it.initFooter(SwipeRecyclerView.LoadMoreListener {
                requestTodoViewModel.getTodoData(false)
            })
            it.initFloatBtn(floatbtn)
        }

        swipeRefresh.init {
            requestTodoViewModel.getTodoData(true)
        }
    }

    override fun createObserver() {
        requestTodoViewModel.todoDataState.observe(viewLifecycleOwner, Observer {
           loadListData(it,todoAdapter,loadSir,recyclerView,swipeRefresh)
        })
    }

    override fun lazyLoadData() {
        loadSir.showLoading()
        requestTodoViewModel.getTodoData(true)
    }
}