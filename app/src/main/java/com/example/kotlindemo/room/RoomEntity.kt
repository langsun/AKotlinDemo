package com.example.kotlindemo.room

import androidx.room.*

/**
 * Author: SKY
 * Date: 2022/6/5
 */
//@Entity注解属性有：
//tableName：设置表名字, 默认是类的名字
//indices：设置索引
//inheritSuperIndices：父类的索引是否会自动被当前类继承。
//primaryKeys：设置主键。
//foreignKeys：设置外键。
@Entity
data class RoomUser (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "userName")
    var name: String ,
    @ColumnInfo(name = "userAge")
    var age: Int
)

@Entity
data class RoomCompany(
    //@PrimaryKey 主键
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    //@ColumnInfo 用于数据库中的名字
    @ColumnInfo(name = "personName")
    var name: String ,
    //@Embedded 用于对象直接嵌套
//    @Embedded
//    var address: Address,
)

@Entity
data class Address(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var province: String,
    var city: String,
    //@Ignore 不存入数据库
//    @Ignore
//    var district: String = ""
)