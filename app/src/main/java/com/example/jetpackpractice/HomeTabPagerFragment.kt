package com.example.jetpackpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.jetpackpractice.adapters.HomeTabAdapter
import com.example.jetpackpractice.databinding.FragmentHomeTabPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeTabPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeTabPagerBinding.inflate(inflater, container, false)
        // !!! must be set in this function, instead of as a variable member
        val adapter = HomeTabAdapter(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.apply {
                    text = "HOME"
                    setIcon(android.R.drawable.ic_menu_gallery)
                }
                1 -> tab.apply {
                    text = "ME"
                    setIcon(android.R.drawable.ic_dialog_email)
                }
            }
        }.attach()
//        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.toolbar.setOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        return binding.root
    }
}