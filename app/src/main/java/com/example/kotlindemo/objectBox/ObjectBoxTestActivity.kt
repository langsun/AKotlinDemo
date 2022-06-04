package com.example.kotlindemo.objectBox

import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.BuildConfig
import com.example.kotlindemo.databinding.ActivityObjectBoxTestBinding
import io.objectbox.android.Admin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Author: SKY
 * Date: 2022/6/3
 */
class ObjectBoxTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityObjectBoxTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjectBoxTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ObjectBoxUtil.getUserBox()
        initClick()
    }

    private fun initClick() {
        binding.put.setOnClickListener {
            UserAction.put(User("zhangs", 18))
            Toast.makeText(this, "添加一个完成", Toast.LENGTH_SHORT).show()
        }

        binding.put.setOnLongClickListener {
            var list = mutableListOf<User>()
            repeat(100) {
                if (it % 3 == 0) {
                    list.add(User("张三$it", 18 + it))
                } else if (it % 5 == 0) {
                    list.add(User("李四$it", 18 + it))
                } else {
                    list.add(User("王五$it", 18 + it))
                }
            }
            UserAction.put(*list.toTypedArray())
            Toast.makeText(this, "添加100个User完成", Toast.LENGTH_SHORT).show()
            false
        }
        binding.remove.setOnClickListener {
            UserAction.remove()
            Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show()
        }

        binding.removeIdGreater.setOnClickListener {
            GlobalScope.launch {
                UserAction.removeIdGreater(50)
            }
        }
    }
}