package com.androiddometest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.androiddometest.bean.TaskData
import com.androiddometest.db.TaskDBStorage
import com.androiddometest.task.AddTaskActivity
import com.androiddometest.task.TaskAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dataList: ArrayList<TaskData>
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskDBStorage: TaskDBStorage


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData() {
        dataList = ArrayList()
        fab_add_task.setOnClickListener(this)
        taskDBStorage = TaskDBStorage(this)

        val linearLayoutManager = LinearLayoutManager(this)
        contentRecycler.setLayoutManager(linearLayoutManager)

        taskAdapter = TaskAdapter(this, dataList!!)
        contentRecycler.adapter = taskAdapter

        queryTaskList()
    }


    private fun queryTaskList() {
        dataList.clear()
        dataList.addAll(taskDBStorage.queryTaskList())
        taskAdapter.notifyDataSetChanged()
        getDBTask()
    }


    private fun getDBTask() {
        val taskDb = TaskDBStorage(this)
        val taskData: TaskData = taskDb.queryTask(dataList[0].id)
        Toast.makeText(this, taskData.title, Toast.LENGTH_LONG).show()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_add_task -> {
                var intent = Intent(this, AddTaskActivity::class.java).apply {
                    putExtra(AddTaskActivity.TITLE_EXTRA, "我是标题")
                        .putExtra(AddTaskActivity.DESCRIPTION_EXTRA, "我是内容")
                }
                startActivityForResult(intent, AddTaskActivity.ADD_TASK_ACTIVITY_CODE)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == AddTaskActivity.ADD_TASK_ACTIVITY_CODE) {
            val taskData = data?.getParcelableExtra<TaskData>(AddTaskActivity.TASK_DATA)
            if (taskData != null) {
                dataList.add(taskData)
                taskAdapter.notifyDataSetChanged()
            }
        }
    }
}
