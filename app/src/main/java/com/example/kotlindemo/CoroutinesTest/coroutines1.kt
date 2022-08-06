package com.example.kotlindemo.CoroutinesTest

/**
 * Author: SKY
 * Date: 2022/8/3
 * 协程基础《一》
 * https://www.kotlincn.net/docs/reference/coroutines/basics.html
 */


//fun main() {
//    GlobalScope.launch {
//        delay(1000)
//        println("wrold")
//    }
//    println("Hello")
//    Thread.sleep(2000)
//}


//fun main(){
//    GlobalScope.launch {
//        delay(1000)
//        println("world")
//    }
//    println("Hello")
//    runBlocking {
//        delay(2000)
//    }
//}


//fun main() = runBlocking {
//    GlobalScope.launch {
//        delay(1000)
//        println("world")
//    }
//    println("hello")
//    delay(2000)
//}

/**
 * 等待一个作业
 */
//val job = GlobalScope.launch {
//    delay(1000)
//    println("world")
//}
//fun main(){
//    println("hello")
//    //这种方式不会打印world
////    GlobalScope.launch{
////        job.join()
////    }
//
//    //这种方式会打印world
//    runBlocking {
//        job.join()
//    }
//}


///**
// * 结构化并发
// */
//fun main() = runBlocking {
//    launch {
//        delay(1000)
//        println("world")
//    }
//    println("hello")
//}

///**
// * 作用域构建器
// * 除了由不同的构建器提供协程作用域之外，还可以使用 coroutineScope 构建器声明自己的作用域。它会创建一个协程作用域并且在所有已启动子协程执行完毕之前不会结束。
// * runBlocking 与 coroutineScope 可能看起来很类似，因为它们都会等待其协程体以及所有子协程结束。 主要区别在于，runBlocking 方法会阻塞当前线程来等待，
// * 而 coroutineScope 只是挂起，会释放底层线程用于其他用途。 由于存在这点差异，runBlocking 是常规函数，而 coroutineScope 是挂起函数。
// */
//fun main() = runBlocking {
//    launch {
//        delay(200)
//        println("Task from runBlocking launch")
//    }
//
//    coroutineScope {
//        launch {
//            delay(500)
//            println("Task from coroutineScope launch")
//        }
//        delay(100)
//        println("Task from coroutineScope")
//    }
//
//    println("Coroutine scope is over")
//}


///**
// * 提取函数重构
// */
//fun main() = runBlocking {
//    launch {
//        doWorld()
//    }
//    println("hello")
//}
//
//private suspend fun doWorld() {
//    delay(1000)
//    println("world")
//}


///**
// * 协程很轻量
// */
//fun main() = runBlocking {
//    repeat(100_000){
//        launch {
//            delay(5000)
//            println("$it")
//        }
//    }
//}

//
///**
// * 全局协程像守护线程
// */
//fun main() = runBlocking {
//    GlobalScope.launch {
//        repeat(10) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//    delay(1300)
//}











