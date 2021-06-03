package com.example.jetpackpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackpractice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        actionBar
        setContentView(binding.root)
    }
}