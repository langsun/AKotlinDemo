package com.example.kotlindemo.room

import androidx.room.*

/**
 * Author: SKY
 * Date: 2022/6/5
 * SQL 语句 https://www.runoob.com/sql/sql-tutorial.html
 */
@Dao
interface RoomUserDao {
    //onConflict 插入有冲突的时候的处理策略
    //REPLACE：取代旧数据同时继续事务  ROLLBACK：回滚事务   ABORT：终止事务  FAIL：事务失败  IGNORE：忽略冲突
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomUser)

    //1、可以设置onConflict来表明冲突的解决办法
    //2、可以返回int变量，表示更新了多少行
    @Update
    fun update(vararg users: RoomUser): Int

    //1、可以设置onConflict来表明冲突的解决办法
    //2、可以返回int变量，表示更新了多少行
    @Delete
    fun deleteUser(vararg users: RoomUser): Int

    @Query("DELETE FROM roomuser")
    fun deleteAll()

    //查询所有
    @Query("SELECT * FROM roomuser")
    fun queryALL(): List<RoomUser>

    //查询通过name
    @Query("SELECT * FROM roomuser WHERE userName == :name")
    fun queryUserFromName(name: String): List<RoomUser>

    //查询通过age区间查询
    @Query("SELECT * FROM roomuser WHERE userAge BETWEEN :minAge AND :maxAge")
    fun queryUserBetweenAge(minAge: Int, maxAge: Int): List<RoomUser>


}