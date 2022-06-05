package com.example.kotlindemo.room

import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.BuildConfig
import com.example.kotlindemo.databinding.ActivityObjectBoxTestBinding
import com.example.kotlindemo.databinding.ActivityRoomTestBinding
import io.objectbox.android.Admin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

/**
 * Author: SKY
 * Date: 2022/6/3
 */
class RoomTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        RoomUtil.getRoomUserDao()


        initClick()
    }

    private fun initClick() {
        binding.put.setOnClickListener {

            RoomUtil.userDao.insert(RoomUser(0,"a",1))
            Toast.makeText(this, "添加一个完成", Toast.LENGTH_SHORT).show()
        }

        binding.put.setOnLongClickListener {
            var list = mutableListOf<RoomUser>()
            repeat(100) {
                if (it % 3 == 0) {
                    list.add(RoomUser(0,"张三$it", 18 + it))
                } else if (it % 5 == 0) {
                    list.add(RoomUser(0,"李四$it", 18 + it))
                } else {
                    list.add(RoomUser(0,"王五$it", 18 + it))
                }
            }
            RoomUtil.userDao.insert(*list.toTypedArray())
            Toast.makeText(this, "添加100个User完成", Toast.LENGTH_SHORT).show()
            false
        }
        binding.remove.setOnClickListener {
            RoomUtil.userDao.deleteAll()
            Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show()
        }

        binding.query.setOnClickListener {
            GlobalScope.launch {
//                RoomUtil.userDao.query()
            }
        }
    }
}