package com.example.kotlindemo.room

import androidx.room.*

/**
 * Author: SKY
 * Date: 2022/6/5
 * SQL 语句 https://www.runoob.com/sql/sql-tutorial.html
 */
@Dao
interface RoomCompanyDao {
    //查询所有
    @Query("SELECT * FROM roomcompany")
    fun queryALL(): List<RoomCompany>
}