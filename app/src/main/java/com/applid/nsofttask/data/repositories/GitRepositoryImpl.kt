package com.applid.nsofttask.data.repositories

import com.applid.nsofttask.data.api.Api
import com.applid.nsofttask.data.api.dto.RepositoryModelDto
import com.applid.nsofttask.domain.repositories.GitRepository

class GitRepositoryImpl constructor(private val api: Api) : GitRepository {
    override suspend fun getAllRepositories(): List<RepositoryModelDto> {
        return api.getRepositories()
    }
}