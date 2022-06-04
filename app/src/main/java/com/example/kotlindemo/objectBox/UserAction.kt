package com.example.kotlindemo.objectBox

import io.objectbox.kotlin.awaitCallInTx
import io.objectbox.kotlin.greater
import java.lang.Exception

/**
 * Author: SKY
 * Date: 2022/6/3
 */
object UserAction {
    fun put(vararg user: User) {
        ObjectBoxUtil.userBox.put(*user)
    }

    fun all(): List<User> {
        return ObjectBoxUtil.userBox.all
    }

    fun get(): User {
        return ObjectBoxUtil.userBox.get(0)
    }

    fun query(name: String): List<User> {
        var user: List<User>? = null
        val query = ObjectBoxUtil.userBox
            .query(User_.name.equal(name))
            .order(User_.age)
            .build()
        user = query.find()
        query.close()
        return user
    }

    fun remove(id: Long = -1L, user: User? = null){
        if(id != -1L){
            ObjectBoxUtil.userBox.remove(id)
            return
        }
        if(null != user){
            ObjectBoxUtil.userBox.remove(user)
            return
        }
        ObjectBoxUtil.userBox.removeAll()
        ObjectBoxUtil.userBox.closeThreadResources()
    }

    //等于 equal  大于 greater  小于 less  和 and  或 or
    suspend fun removeIdGreater(id: Long){
        var userList: List<User>? = null
        try {
            ObjectBox.store.awaitCallInTx{
                val query = ObjectBoxUtil.userBox
                    .query(User_.id greater id)
                    .build()
                userList = query.find()
                query.close()
                userList?.let {
                    ObjectBoxUtil.userBox.remove(it)
                }
            }
        } catch (e:Exception){

        }

    }
    fun count():Long{
        return ObjectBoxUtil.userBox.count()
    }


}