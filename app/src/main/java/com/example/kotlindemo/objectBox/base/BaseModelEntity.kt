package com.example.kotlindemo.objectBox

import com.example.kotlindemo.objectBox.base.ObjectBoxEntityImpl
import com.example.kotlindemo.objectBox.base.ObjectBoxEntityImpl.Companion.ID_NEW
import io.objectbox.annotation.BaseEntity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Transient
import io.objectbox.annotation.Unique

/**
 * Objectbox的数据仓库的基础类，必须继承该类
 *
 * @author ouyangshaopcong
 */
@BaseEntity
abstract class BaseModelEntity : ObjectBoxEntityImpl {
    /**
     * 数据库表id表示
     *  0：表示新增
     * -1：表示删除
     * >0：表示查询或更新
     */
    companion object {

        /**
         * 判断2个列表是否相等
         */
        fun <T> isEquals(other: List<T>, these: List<T>): Boolean {
            //都是空列表，返回相等
            if (other.isEmpty() && these.isEmpty()) return true
            //列表长度不同，返回不相等
            if (other.size != these.size) return false
            //找不到不同卡片，返回相等
            val first = other.firstOrNull {
                !these.contains(it)
            }
            val second = these.firstOrNull {
                !other.contains(it)
            }
            //同时为null，表示列表相等，否则列表不等
            return (first == null) && (second == null)
        }
    }

    override fun hashCode(): Int {
        return uid.hashCode()
    }


    @Id(assignable = true)
    override var id: Long = ID_NEW

    @Unique
    override var unique: String = ""

    var uid: Int = 0

    // 每次更新会更新时间戳
    override var timestamp: Long = 0

    /**
     * 默认产生的unique
     */
    override fun providerUnique(): String = "$uid"
}