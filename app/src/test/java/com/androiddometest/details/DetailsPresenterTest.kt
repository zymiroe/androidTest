package com.androiddometest.details

import com.androiddometest.base.BaseMocksTest
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


/**
 * 详情页面单测
 *
 * @author zhouyong
 * @date 2018-01-23 14:13
 * @version V 1.0
 */
class DetailsPresenterTest : BaseMocksTest() {
    @Mock
    private lateinit var mDetailsActivity: DetailsActivity
    @Mock
    private lateinit var mView: DetailsContract.View

    private lateinit var mPresenter: DetailsPresenter

    @Test
    fun getDetail() {
        mPresenter = DetailsPresenter(mDetailsActivity, mView)
        mPresenter.getDetails("我在写单测")
        Mockito.verify(mView).showDetails("我在写单测")
    }

}