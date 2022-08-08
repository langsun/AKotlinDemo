package com.example.kotlindemo.CoroutinesTest

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Author: SKY
 * Date: 2022/8/8
 * 协程上下文与调度器
 * https://www.kotlincn.net/docs/reference/coroutines/coroutine-context-and-dispatchers.html
 */

/**
 * 协程上下文与调度器
 */
//fun main() = runBlocking<Unit> {
//    launch {
//        println("main runBlocking : i'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.Default) {
//        println("Default : i'm working in thread ${Thread.currentThread().name}")
//    }
//    //非受限调度器
//    launch(Dispatchers.Unconfined) {
//        //thread main
//        println("Unconfined start: i'm working in thread ${Thread.currentThread().name}")
//        delay(500)
//        //thread kotlinx.coroutines.DefaultExecutor
//        println("Unconfined end: i'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.IO) {
//        println("IO : i'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(newSingleThreadContext("TheFirst")) {
//        println("newSingleThreadContext : i'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(newFixedThreadPoolContext(3,"TheFixed")) {
//        println("newSingleThreadContext : i'm working in thread ${Thread.currentThread().name}")
//    }
////    launch(Dispatchers.Main) {
////        println("IO : i'm working in thread ${Thread.currentThread().name}")
////    }
//
//    launch(Job(coroutineContext[Job])) {
//
//    }
//
//    launch(SupervisorJob(coroutineContext[Job])) {  }
//}


/**
 * 在不同的线程中跳转
 */
//fun main() {
//    newSingleThreadContext("one").use { one ->
//        newSingleThreadContext("two").use { two ->
//            runBlocking(one) {
//                println("start in runBlocking $two")
//                withContext(two){
//                    println("run in withContext $one")
//                }
//                println("end in runBlocking $two")
//            }
//        }
//    }
//}


/**
 * 子协程
 *
 * 当使用 GlobalScope 来启动一个协程时，则新协程的作业没有父作业。 因此它与这个启动的作用域无关且独立运作
 */
//fun main() = runBlocking {
//    val request = launch {
//        // 孵化了两个子作业, 其中一个通过 GlobalScope 启动
//        GlobalScope.launch {
//            println("job1: I run in GlobalScope and execute independently!")
//            delay(1000)
//            println("job1: I am not affected by cancellation of the request")
//        }
//        // 另一个则承袭了父协程的上下文
//        launch {
//            delay(100)
//            println("job2: I am a child of the request coroutine")
//            delay(1000)
//            println("job2: I will not execute this line if my parent request is cancelled")
//        }
//    }
//
//    delay(500)
//    request.cancel()
//    delay(1000)
//    println("main: Who has survived request cancellation?")
//}


/**
 * 父协程的职责
 */
fun main() = runBlocking {
    val job = launch {
        repeat(3){ i ->
            launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    job.join() // 等待请求的完成，包括其所有子协程
    println("Now processing of the request is complete")
}