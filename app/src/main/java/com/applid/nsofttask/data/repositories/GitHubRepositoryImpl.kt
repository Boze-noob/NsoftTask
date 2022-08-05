package com.applid.nsofttask.data.repositories

import android.util.Log
import com.applid.nsofttask.data.api.Api
import com.applid.nsofttask.data.api.dto.RepositoryContributorModelDto
import com.applid.nsofttask.data.api.dto.RepositoryDetailsModelDto
import com.applid.nsofttask.data.api.dto.RepositoryModelDto
import com.applid.nsofttask.domain.repositories.GitHubRepository
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(private val api: Api) : GitHubRepository {
    override suspend fun getAllRepositories(): RepositoryModelDto {
        return api.getRepositories()
    }

    override suspend fun getRepositoriesByName(name: String): RepositoryModelDto {
        Log.d("Tag", "we are searching by $name")
        return api.getRepositoriesByName(name = name, language = "kotlin", order = "desc", sort = "stars")
    }

    override suspend fun getRepositoryDetails(owner : String, name : String): RepositoryDetailsModelDto {
        return api.getRepositoryDetails(owner = owner, name = name)
    }

    override suspend fun getRepositoryContributors(contributorsUrl : String): List<RepositoryContributorModelDto> {
        return api.getRepositoryContributors(contributorsUrl = contributorsUrl)
    }


}