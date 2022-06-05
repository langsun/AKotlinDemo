package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.databinding.ActivityMainBinding
import com.example.kotlindemo.objectBox.ObjectBoxTestActivity
import com.example.kotlindemo.room.RoomTestActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.objectBox.setOnClickListener {
            startActivity(Intent(MainActivity@this, ObjectBoxTestActivity::class.java))
        }
        binding.room.setOnClickListener {
            startActivity(Intent(MainActivity@this, RoomTestActivity::class.java))
        }
    }
}