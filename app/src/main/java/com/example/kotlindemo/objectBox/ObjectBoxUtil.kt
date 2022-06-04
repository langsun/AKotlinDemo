package com.example.kotlindemo.objectBox

import io.objectbox.Box

/**
 * Author: SKY
 * Date: 2022/6/3
 */
object ObjectBoxUtil {
    lateinit var userBox: Box<User>
        private set

    fun getUserBox(){
        userBox = ObjectBox.store.boxFor(User::class.java)
    }

}