package com.example.jetpackpractice.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.jetpackpractice.data.Card
import com.example.jetpackpractice.data.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(var repository: CardRepository) : ViewModel() {
    var cards: Flow<PagingData<Card>>? = null

    fun load(): Flow<PagingData<Card>> {
        return repository.fetchCardsFor(39)
    }
}