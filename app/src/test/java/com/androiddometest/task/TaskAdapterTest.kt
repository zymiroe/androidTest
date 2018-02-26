package com.androiddometest.task

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.androiddometest.bean.TaskData
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * 适配器单测
 *
 * @author zhouyong
 * @version V 1.0
 * @date 2018-01-24 18:03
 */
class TaskAdapterTest {
    @Mock
    private lateinit var mContext: Context

    private lateinit var listData: ArrayList<TaskData>

    private lateinit var taskAdapter: TaskAdapter
    @Mock
    private lateinit var recyclerView: RecyclerView


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        listData = ArrayList()
        listData.add(TaskData("java", "内容"))
        listData.add(TaskData("java1", "内容1"))
        listData.add(TaskData("java2", "内容2"))

        taskAdapter = TaskAdapter(mContext, listData)
        recyclerView.adapter = taskAdapter
    }

    @Test
    fun onCreateViewHolder() {

    }

    @Test
    fun onBindViewHolder() {

    }

}