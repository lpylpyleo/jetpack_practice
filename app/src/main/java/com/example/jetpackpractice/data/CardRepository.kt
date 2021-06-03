package com.example.jetpackpractice.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jetpackpractice.api.MatsuriService
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CardRepository @Inject constructor(private val service:MatsuriService) {
    fun fetchCardsFor(idolId:Int):Flow<PagingData<Card>>{
       return Pager(
           config= PagingConfig(enablePlaceholders = false,pageSize = 20),
        pagingSourceFactory ={CardPagingSource(service)}
       ).flow
    }
}