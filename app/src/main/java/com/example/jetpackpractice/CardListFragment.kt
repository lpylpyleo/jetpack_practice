package com.example.jetpackpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.jetpackpractice.adapters.CardListAdapter
import com.example.jetpackpractice.databinding.FragmentCardListBinding
import com.example.jetpackpractice.viewModels.CardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [CardListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CardListFragment : Fragment() {
    private val adapter = CardListAdapter()
    private val viewModel: CardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCardListBinding.inflate(inflater, container, false)
        binding.cardList.adapter = adapter
        lifecycleScope.launch {
            viewModel.load().collectLatest {
                adapter.submitData(it)
            }
        }

        return binding.root
    }

}