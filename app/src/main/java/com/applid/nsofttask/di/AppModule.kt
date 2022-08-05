package com.applid.nsofttask.di

import com.applid.nsofttask.common.Constants
import com.applid.nsofttask.data.api.Api
import com.applid.nsofttask.data.repositories.GitHubRepositoryImpl
import com.applid.nsofttask.domain.repositories.GitHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi() : Api {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideGitRepository(api : Api) : GitHubRepository {
        return GitHubRepositoryImpl(api = api)
    }

}