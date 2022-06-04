package com.example.kotlindemo.objectBox

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Author: SKY
 * Date: 2022/6/3
 */

@Entity
data class User(
    var name: String? = null,
    var age: Int = 0
) : BaseModelEntity()