package com.androiddometest.db

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.androiddometest.bean.TaskData
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 *
 *
 * @author zhouyong
 * @version V 1.0
 * @date 2018-01-25 23:01
 */
@RunWith(AndroidJUnit4::class)
class TaskDBStorageTest {
    private lateinit var mTaskDBStorage: TaskDBStorage

    @Before
    fun setUp1() {
        mTaskDBStorage = TaskDBStorage(InstrumentationRegistry.getTargetContext())
        mTaskDBStorage.openDB()
    }

    @Test
    fun testPreConditions() {
        Assert.assertNotNull(mTaskDBStorage)
    }

    @Test
    fun saveTask() {
        val taskData = TaskData("单测title", "单测内容", "1s2_232de")
        mTaskDBStorage.saveTask(taskData)

        val taskList: ArrayList<TaskData> = mTaskDBStorage.queryTaskList()
        MatcherAssert.assertThat<Int>(taskList.size, CoreMatchers.`is`(1))
        MatcherAssert.assertThat(taskList.get(0).title, CoreMatchers.`is`("单测title"))
        MatcherAssert.assertThat(taskList.get(0).description, CoreMatchers.`is`("单测内容"))
    }

    @Test
    fun queryTask() {
//        val taskDataQuery = TaskData("单测查询title", "单测查询内容", "1s2_232_query")
//        mTaskDBStorage.saveTask(taskDataQuery)
        val taskData = mTaskDBStorage.queryTask("1s2_232de")
        MatcherAssert.assertThat(taskData.title, CoreMatchers.`is`("单测title"))
        MatcherAssert.assertThat(taskData.description, CoreMatchers.`is`("单测内容"))

    }

    @Test
    fun queryTaskList() {
        val taskList: ArrayList<TaskData> = mTaskDBStorage.queryTaskList()
        // The list is empty
        MatcherAssert.assertThat(taskList.size, CoreMatchers.`is`(1))
    }


    private fun assertTask(task: TaskData?, id: String, title: String, description: String) {
        MatcherAssert.assertThat<TaskData>(task as TaskData, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(task.id, CoreMatchers.`is`(id))
        MatcherAssert.assertThat(task.title, CoreMatchers.`is`(title))
        MatcherAssert.assertThat(task.description, CoreMatchers.`is`(description))
    }
}