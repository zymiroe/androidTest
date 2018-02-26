package com.androiddometest.task

import android.content.Context
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


/**
 * 添加 task 单元测试
 *
 * @author zhouyong
 * @date 2018-01-24 17:41
 * @version V 1.0
 */
class AddTaskPresentTest {

    @Mock
    private lateinit var mContext: Context
    @Mock
    private lateinit var mView: AddTaskContract.View

    private lateinit var mPresenter: AddTaskPresenter


    @Before
    fun setupMocksAndView() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun saveTaskDataTest() {
        mPresenter = AddTaskPresenter(mContext, mView)
        mPresenter.start()
        mPresenter.saveTaskData("java", "java内容")
    }

}