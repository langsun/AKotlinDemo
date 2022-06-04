package com.example.kotlindemo.objectBox.base

interface ObjectBoxEntityImpl {

    var id: Long

    var unique: String

    var timestamp: Long

    fun providerUnique(): String

    companion object{
        const val ID_NEW = 0L
        const val ID_DELETE = -1L
    }
}