package com.example.kotlindemo

import android.app.Application
import com.example.kotlindemo.objectBox.ObjectBox
import io.objectbox.android.Admin

/**
 * Author: SKY
 * Date: 2022/6/3
 */
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }
}