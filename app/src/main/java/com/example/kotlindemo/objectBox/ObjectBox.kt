package com.example.kotlindemo.objectBox

import android.content.Context
import com.example.kotlindemo.BuildConfig
import io.objectbox.BoxStore
import io.objectbox.android.Admin

/**
 * Author: SKY
 * Date: 2022/6/3
 */
object ObjectBox {
    lateinit var store: BoxStore
        private set
    fun init(context: Context){
        store = MyObjectBox.builder().androidContext(context).build()
        if(BuildConfig.DEBUG){
            Admin(store).start(context)
        }
    }
}