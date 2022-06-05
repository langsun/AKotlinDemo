package com.example.kotlindemo.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Author: SKY
 * Date: 2022/6/5
 */
//@Database属性：
//entities：DaoDataBase包含的实体类，可以是多个
//version: 数据库版本
//exportSchema: 把Schema导出到一个文件夹中
@Database(entities = [RoomUser::class, RoomCompany::class], version = 1, exportSchema = true)
abstract class DaoDataBase: RoomDatabase() {
    abstract fun user(): RoomUserDao
    abstract fun company(): RoomCompanyDao
}