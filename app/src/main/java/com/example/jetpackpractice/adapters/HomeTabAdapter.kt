package com.example.jetpackpractice.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jetpackpractice.CardListFragment
import com.example.jetpackpractice.MeFragment
import java.lang.IndexOutOfBoundsException

class HomeTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CardListFragment()
            1 -> MeFragment()
            else -> throw IndexOutOfBoundsException()
        }
    }
}