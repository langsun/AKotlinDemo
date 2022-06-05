package com.example.kotlindemo.room

import android.content.Context
import androidx.room.Room
import com.example.kotlindemo.BaseApplication

/**
 * Author: SKY
 * Date: 2022/6/5
 */
object RoomUtil {
    lateinit var db: DaoDataBase
        private set
    lateinit var userDao: RoomUserDao
        private set
    lateinit var companyDao: RoomCompanyDao
        private set

    fun init(context: Context) {
        //尽量放在io线程操作
        //Room.databaseBuilder() 创建一个Database对象，并创建一个数据库在文件系统中
        //Room.inMemoryDatabaseBuilder() 创建一个Database对象，并创建一个数据库在内存中，同时杀死进程，数据库也没了
        db = Room.databaseBuilder(context, DaoDataBase::class.java, "roomDb")
//            .allowMainThreadQueries() //如果在主线程则需要添加这个
            .build()
    }

    fun getRoomUserDao(): RoomUserDao {
        userDao = db.user()
        return userDao
    }

    fun getRoomCompanyDao(): RoomCompanyDao {
        companyDao = db.company()
        return companyDao
    }
}