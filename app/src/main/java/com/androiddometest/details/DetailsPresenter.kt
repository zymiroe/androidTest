package com.androiddometest.details

import android.content.Context

/**
 *
 * @author zhouyong
 * @date 2018-01-22 22:15
 * @version V 1.0
 */
class DetailsPresenter : DetailsContract.Presenter {
    private var mContext: Context? = null
    private var mView: DetailsContract.View

    constructor (context: Context, view: DetailsContract.View) {
        this.mContext = context
        this.mView = view
    }

    override fun getDetails(string: String) {
        mView.showDetails(string)
    }
}