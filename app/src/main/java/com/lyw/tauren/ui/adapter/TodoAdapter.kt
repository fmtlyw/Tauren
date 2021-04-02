package com.lyw.tauren.ui.adapter

import android.util.Log
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.tauren.R
import com.lyw.tauren.data.model.been.TodoResponse

/**
 * 功能描述:
 * Created on 2021/1/29.
 * @author lyw
 */
class TodoAdapter(data : ArrayList<TodoResponse>) :BaseQuickAdapter<TodoResponse,BaseViewHolder>(R.layout.item_todo,data){
    override fun convert(holder: BaseViewHolder, item: TodoResponse) {
        TODO("Not yet implemented")
        Log.d("lyw","TodoAdapter-->convert")
    }
}