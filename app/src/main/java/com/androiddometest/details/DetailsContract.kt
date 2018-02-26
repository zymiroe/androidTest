package com.androiddometest.details

/**
 * ${todo}【用一句话描述该文件做什么】
 *
 * @author zhouyong
 * @date 2018-01-22 18:43
 * @version V 1.0
 */

class DetailsContract {

    interface View {
        fun showDetails(stringName: String)
    }

    interface Presenter {
        fun getDetails(stringName: String)
    }
}