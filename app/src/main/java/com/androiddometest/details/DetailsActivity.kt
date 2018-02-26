/**/
package com.androiddometest.details

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.androiddometest.R
import kotlinx.android.synthetic.main.details_activity.*

/**
 * ${todo}【用一句话描述该文件做什么】
 *
 * @author zhouyong
 * @date 2018-01-22 18:33
 * @version V 1.0
 */
class DetailsActivity : Activity(), DetailsContract.View {
    private lateinit var mDetailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        initData()
    }

    private fun initData() {
        mDetailsPresenter = DetailsPresenter(this,this)
        mDetailsPresenter.getDetails("我是activity传递的过来的数据")
    }

    override fun showDetails(string: String) {
        tvDetailsInfor.text = string
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }
}