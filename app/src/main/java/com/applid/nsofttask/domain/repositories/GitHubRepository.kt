package com.applid.nsofttask.domain.repositories

import com.applid.nsofttask.data.api.dto.RepositoryContributorModelDto
import com.applid.nsofttask.data.api.dto.RepositoryDetailsModelDto
import com.applid.nsofttask.data.api.dto.RepositoryModelDto

interface GitHubRepository {
    suspend fun getAllRepositories() : RepositoryModelDto
    suspend fun getRepositoryDetails(owner : String, name : String) : RepositoryDetailsModelDto
    suspend fun getRepositoryContributors(contributorsUrl : String) : List<RepositoryContributorModelDto>
}