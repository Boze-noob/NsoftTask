package com.applid.nsofttask.data.api

import com.applid.nsofttask.data.api.dto.RepositoryModelDto
import retrofit2.http.GET

interface Api {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    suspend fun getRepositories() : RepositoryModelDto
}