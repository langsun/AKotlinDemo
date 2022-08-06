package com.example.kotlindemo.CoroutinesTest

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Author: SKY
 * Date: 2022/8/3
 * 协程 组合挂起函数
 * https://www.kotlincn.net/docs/reference/coroutines/composing-suspending-functions.html
 */

suspend fun doSomethingUsefulOne(): Int{
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int{
    delay(1000L)
    return 12
}

///**
// * 默认顺序调用
// * The answer is 42
// * Completed in 2017 ms
// */
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = doSomethingUsefulOne()
//        val two = doSomethingUsefulTwo()
//        println("The answer is ${one + two}")
//    }
//    println("Completed in $time ms")
//}


