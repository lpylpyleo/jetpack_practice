package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.jetpackpractice.adapters.CardListAdapter
import com.example.jetpackpractice.databinding.ActivityMainBinding
import com.example.jetpackpractice.viewModels.CardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val adapter = CardListAdapter()
    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.cardList.adapter = adapter
        lifecycleScope.launch {
            viewModel.load().collectLatest {
                adapter.submitData(it)
            }
        }
        setContentView(binding.root)
    }
}