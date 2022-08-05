package com.applid.nsofttask.data.api

import com.applid.nsofttask.data.api.dto.RepositoryContributorsModelDto
import com.applid.nsofttask.data.api.dto.RepositoryDetailsModelDto
import com.applid.nsofttask.data.api.dto.RepositoryModelDto
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    suspend fun getRepositories(): RepositoryModelDto

    @GET("repos/{owner}/{name}")
    suspend fun getRepositoryDetails(
        @Path("owner") owner: String,
        @Path("name") name: String
    ): RepositoryDetailsModelDto

    @GET("{contributorsUrl}")
    suspend fun getRepositoryContributors(@Path("contributorsUrl") contributorsUrl: String): RepositoryContributorsModelDto
}