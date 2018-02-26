package com.androiddometest


/**
 *
 * @author zhouyong
 * @date 2018-01-23 16:30
 * @version V 1.0
 */
class MainContrack {

    interface Presenter {
        fun getTaskList()
    }

    interface View {
        fun showTaskList()
    }
}

