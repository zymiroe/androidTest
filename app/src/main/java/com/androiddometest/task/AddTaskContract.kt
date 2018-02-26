package com.androiddometest.task

import com.androiddometest.BasePresenter
import com.androiddometest.BaseView
import com.androiddometest.bean.TaskData


/**
 *
 *
 * @author zhouyong
 * @date 2018-01-23 17:16
 * @version V 1.0
 */
class AddTaskContract {

    interface Presenter : BasePresenter {
        fun saveTaskData(title: String, description: String)

        fun insertTaskToDB(task: TaskData)

    }

    interface View : BaseView<Presenter> {
        fun updateTaskData(task: TaskData)
    }

}