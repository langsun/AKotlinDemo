package com.example.kotlindemo.CoroutinesTest

import kotlinx.coroutines.*

/**
 * Author: SKY
 * Date: 2022/8/3
 * 协程 取消与超时
 * https://www.kotlincn.net/docs/reference/coroutines/basics.html
 */

///**
// * 取消协程的执行
// */
//fun main() = runBlocking {
//    val job = launch {
//        repeat(100){
//            println("this is $it times")
//            delay(500)
//        }
//    }
//
//    delay(1300)
//    println("main: i'm tired of waiting")
//    job.cancel()
//    println("job.isActive = ${job.isActive}") //false
//    println("job.isCancelled = ${job.isCancelled}")//true
//    println("job.isCompleted = ${job.isCompleted}")//false
//    job.join()
//    println("job.isActive  = ${job.isActive}")//false
//    println("job.isCancelled = ${job.isCancelled}")//true
//    println("job.isCompleted = ${job.isCompleted}")//true
//    println("main: Now i can quit")
//}


///**
// * 取消是协作的
// * 协程的取消是 协作 的。一段协程代码必须协作才能被取消。 所有 kotlinx.coroutines 中的挂起函数都是 可被取消的 。它们检查协程的取消，
// * 并在取消时抛出 CancellationException。 然而，如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的
// */
//fun main() = runBlocking {
//    var startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        //当执行job.cancelAndJoin()时，协程正在执行计算任务，没有进行取消检查，所有不能被取消
//        while (i < 5){
//            if(System.currentTimeMillis() >= nextPrintTime){
//                println("job: this is ${i++} times")
//                nextPrintTime += 500L
//            }
//        }
//
////        //可以被正常取消
////        while (isActive){
////            if(System.currentTimeMillis() >= nextPrintTime){
////                println("job: this is ${i++} times")
////                nextPrintTime += 500L
////            }
////        }
//    }
//
//    delay(1300L)
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main: Now I can quit.")
//}

///**
// * 协程取消后 在finally中释放资源
// */
//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000){
//                println("job: this is $it times")
//                delay(500)
//            }
//        } finally {
//            println("job: I'm running finally")
//        }
//    }
//    delay(1300)
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并且等待它结束
//    println("main: Now I can quit.")
//}

///**
// * 运行不能取消的代码块
// */
//fun main() = runBlocking {
//    val job = launch {
//        try {
//            repeat(1000){
//                println("job: this is $it  times")
//                delay(500L)
//            }
//        } finally {
//            withContext(NonCancellable){
//                println("job: I'm running finally")
//                delay(1000L)
//                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
//            }
//        }
//    }
//    delay(1300)
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并等待它结束
//    println("main: Now I can quit.")
//}

///**
// * 超时
// */
//fun main() = runBlocking {
//
////    //会发生：  Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1300 ms
////    withTimeout(1300) {
////        repeat(1000) {
////            println("this is $it times")
////            delay(500L)
////        }
////    }
//
//
////    //方法一：需要try  catch
////    try {
////        withTimeout(1300) {
////            repeat(1000) {
////                println("this is $it times")
////                delay(500L)
////            }
////        }
////    } catch (e:Exception){
////        println("Exception is ${e.message}")
////    }
//
//
//    //方法二： withTimeoutOrNull
//    val result = withTimeoutOrNull(1300) {
//        repeat(1000) {
//            println("this is $it times")
//            delay(500L)
//        }
//        "done"
//    }
//    println("Result is $result")
//}



var acquired = 0

class Resource {
    init { acquired++ } // Acquire the resource
    fun close() { acquired-- } // Release the resource
}

fun main() {
    runBlocking {
        println("eeee $acquired")
        repeat(100_000) { // Launch 100K coroutines
            launch {
                val resource = withTimeout(100) { // Timeout of 60 ms
                    delay(50) // Delay for 50 ms
                    println("dddd $acquired")
                    Resource() // Acquire a resource and return it from withTimeout block
                }
                println("aaaa $acquired")
                resource.close() // Release the resource
                println("bbbb $acquired")
            }
        }
    }
    // Outside of runBlocking all coroutines have completed
    println("cccc $acquired") // Print the number of resources still acquired
}
