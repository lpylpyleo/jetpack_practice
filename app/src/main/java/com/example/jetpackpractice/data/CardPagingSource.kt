package com.example.jetpackpractice.data

import androidx.paging.PagingSource
import com.example.jetpackpractice.api.MatsuriService

class CardPagingSource(private val service: MatsuriService) : PagingSource<Int, Card>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Card> {
        return try {
            val response = service.searchCards(39)
            LoadResult.Page(data = response, nextKey = null, prevKey =null)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}