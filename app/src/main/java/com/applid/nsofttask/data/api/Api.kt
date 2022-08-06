package com.applid.nsofttask.data.api

import com.applid.nsofttask.data.api.dto.RepositoryContributorModelDto
import com.applid.nsofttask.data.api.dto.RepositoryDetailsModelDto
import com.applid.nsofttask.data.api.dto.RepositoryModelDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface Api {

    @GET("search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend fun getRepositories(): RepositoryModelDto

    @GET("search/repositories")
    suspend fun getRepositoriesByName(@Query("q", encoded = true) name : String) : RepositoryModelDto

    @GET("repos/{owner}/{name}")
    suspend fun getRepositoryDetails(
        @Path("owner") owner: String,
        @Path("name") name: String
    ): RepositoryDetailsModelDto

    @GET()
    suspend fun getRepositoryContributors(@Url contributorsUrl: String): Response<List<RepositoryContributorModelDto>>
}