package com.androiddometest.task

import android.content.Context
import com.androiddometest.bean.TaskData
import com.androiddometest.db.TaskDBStorage


/**
 * 添加 task presenter
 *
 * @author zhouyong
 * @date 2018-01-24 09:38
 * @version V 1.0
 */
class AddTaskPresenter : AddTaskContract.Presenter {
    private var mContext: Context
    private var mView: AddTaskContract.View
    private lateinit var mTaskDBStorage: TaskDBStorage

    @JvmOverloads constructor(context: Context, view: AddTaskContract.View) {
        this.mContext = context
        this.mView = view
        start()
    }

    override fun start() {
        mView.setPresenter(this)
        mTaskDBStorage = TaskDBStorage(mContext)
    }

    override fun saveTaskData(title: String, description: String) {
        val task = TaskData(title, description)
        mView.updateTaskData(task)
    }

    override fun insertTaskToDB(task: TaskData) {
        mTaskDBStorage.saveTask(task)
    }
}