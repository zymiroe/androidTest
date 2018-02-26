package com.androiddometest.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQueryBuilder
import com.androiddometest.bean.TaskData


/**
 * 数据库数据操作
 *
 * @author zhouyong
 * @date 2018-01-24 22:55
 * @version V 1.0
 */
class TaskDBStorage : TaskStorage {

    private var mDBHelper: DBOpenHelper
    private var mContext: Context
    private lateinit var db: SQLiteDatabase

    constructor(context: Context) {
        this.mContext = context
        mDBHelper = DBOpenHelper(mContext)
        openDB()
    }

    fun openDB() {
        db = mDBHelper.writableDatabase
    }

    override fun saveTask(taskData: TaskData) {
        db.beginTransaction()
        val sql = ("insert into " + DBOpenHelper.TABLE_PRODUCTS
            + " (" + DBOpenHelper.COLUMN_TASK_ID + ", "
            + DBOpenHelper.COLUMN_TITLE + ", "
            + DBOpenHelper.COLUMN_DESCRIPTION + ") values(?,?,?)")

        db.execSQL(sql, arrayOf(taskData.id, taskData.title, taskData.description))
        db.setTransactionSuccessful()
        db.endTransaction()
    }

    override fun deleteTask(taskData: TaskData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun queryTask(taskId: String): TaskData {
        val query = " select * from " + DBOpenHelper.TABLE_PRODUCTS + " where " + DBOpenHelper.COLUMN_TASK_ID + " = " + "'" + taskId + "' "
        val cursor = db.rawQuery(query, null)
        var task: TaskData
        if (cursor.moveToNext()) {
            val id = cursor.getString(1)
            val name = cursor.getString(2)
            val description = cursor.getString(3)
            task = TaskData(name, description, id)
            cursor.close()
        } else {
            task = TaskData()
        }
        return task
    }

    override fun updateTask(taskId: String) {

    }


    /***
     * 查询数据库中所有数据
     */
    override fun queryTaskList(): ArrayList<TaskData> {
        var queryList: ArrayList<TaskData> = ArrayList()
        val sql = SQLiteQueryBuilder.buildQueryString(false, DBOpenHelper.TABLE_PRODUCTS, PROJECTION_SEARCH_HISTORY, null, null, null, null, "100")
        val cursor = db.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            val taskData: TaskData
            val id = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_TASK_ID))
            val name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_TITLE))
            val description = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_DESCRIPTION))
            taskData = TaskData(name, description, id)
            queryList.add(taskData)
        }
        cursor.close()
        return queryList
    }

    companion object {
        val PROJECTION_SEARCH_HISTORY: Array<String> = arrayOf(DBOpenHelper.COLUMN_TASK_ID, DBOpenHelper.COLUMN_TITLE, DBOpenHelper.COLUMN_DESCRIPTION)
    }

    fun closeDB() {
        if (db != null) {
            db.close()
        }
    }
}