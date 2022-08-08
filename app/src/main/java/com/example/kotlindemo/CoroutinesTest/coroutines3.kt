package com.example.kotlindemo.CoroutinesTest

import kotlinx.coroutines.*
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


///**
// * 使用async并发
// */
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = async {
//            doSomethingUsefulOne()
//        }
//
//        val two = async {
//            doSomethingUsefulTwo()
//        }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("completed is $time ms")
//}

///**
// * 懒惰启动的async
// */
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) {
//            doSomethingUsefulOne()
//        }
//        val two = async(start = CoroutineStart.LAZY) {
//            doSomethingUsefulTwo()
//        }
//        //启动
//        one.start()
//        two.start()
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("completed is $time ms")
//}


///**
// * async风格的函数
// */
//fun somethingUsefulOneAsync() = GlobalScope.async {
//    doSomethingUsefulOne()
//}
//
//fun somethingUsefulTwoAsync() = GlobalScope.async {
//    doSomethingUsefulTwo()
//}
//
//fun main() {
//    val time = measureTimeMillis {
//        val one = somethingUsefulOneAsync()
//        val two = somethingUsefulTwoAsync()
//        runBlocking {
//            println("the answer is ${one.await() + two.await()}")
//        }
//    }
//    println("Completed is $time ms")
//}

///**
// * 使用async的结构化并发
// */
//suspend fun concurrentSum() = coroutineScope {
//    val one = async { doSomethingUsefulOne() }
//    val two = async { doSomethingUsefulTwo() }
//    one.await() + two.await()
//}
//
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        println("the answer is ${concurrentSum()}")
//    }
//    println("completed is $time ms")
//}


/**
 * 协程的取消是通过协程的层次结构进行传递
 */
suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE) // 模拟一个长时间的运算
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}

fun main() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    } catch(e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}








