package com.example.jetpackpractice.di

import com.example.jetpackpractice.api.MatsuriService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideMatsuriService():MatsuriService{
        return MatsuriService.create()
    }
}