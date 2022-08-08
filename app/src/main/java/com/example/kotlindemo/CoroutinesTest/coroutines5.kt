package com.example.kotlindemo.CoroutinesTest

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Author: SKY
 * Date: 2022/8/8
 * 异步流
 * https://www.kotlincn.net/docs/reference/coroutines/flow.html
 */

/**
 * 表示多个值 集合
 */
//fun simple(): List<Int> = listOf(1,2,3)
//fun main(){
//    simple().forEach{ value ->
//        println("value is $value")
//    }
//}

/**
 * 序列
 */
//fun simple():Sequence<Int> = sequence {
//    for (i in 1..3){
//        Thread.sleep(1000)
//        yield(i)
//    }
//}
//
//fun main(){
//    simple().forEach { value ->
//        println("value is $value")
//    }
//}


/**
 * 挂起函数
 */
//suspend fun simple(): List<Int> {
//    delay(1000)
//    return listOf(1,2,3,4)
//}
//
//fun main() = runBlocking {
//    simple().forEach { value ->
//        println("value is $value")
//    }
//}


/**
 * 流
 */
//fun simple(): Flow<Int> = flow {
//    for (i in 1..3){
//        delay(100)
//        emit(i)
//    }
//}
//
//fun main() = runBlocking {
//    // 启动并发的协程以验证主线程并未阻塞
//    launch {
//        for (k in 1..3) {
//            println("I'm not blocked $k")
//            delay(100)
//        }
//    }
//
//    simple().collect { value ->
//        println(value)
//    }
//}

/**
 * 流是冷的
 * Flow 是一种类似于序列的冷流 — 这段 flow 构建器中的代码直到流被收集的时候才运行
 */
//fun simple() = flowOf(1,2,3,4)
//
//fun main() = runBlocking {
//    val flow = simple()
//    flow.collect { value -> println("value = $value")  }
//    flow.collect { value -> println("value is $value")  }
//}

/**
 * 流取消的基础
 */
//fun simple():Flow<Int> = flow {
//    for (i in 1..4){
//        delay(100)
//        emit(i)
//    }
//}
//
//fun main() = runBlocking<Unit> {
//    withTimeoutOrNull(250){
//        simple().collect { value ->
//            println("value = $value")
//        }
//    }
//    println("Done")
//}

/**
 * 流的构建
 */

fun flow1() = flow<Int> {
    for (i in 1..4){
        emit(i)
    }
}

fun flow2() = flowOf(1,2,3,4)

fun flow3() = (1..4).asFlow()

fun flow4() = listOf<Int>(1,3,5).asFlow()

fun main(){
//    flow1().buffer()
    flow1().cancellable()
}

/**
 * 转换操作符
 * map
 * transform   我们可以 发射 任意值任意次
 * filter
 *
 * 限长操作符
 * take(3)  取前三个
 *
 * 末端操作符
 *
 */




