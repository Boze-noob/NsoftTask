package com.applid.nsofttask.domain.repositories

import com.applid.nsofttask.data.api.dto.RepositoryModelDto

interface GitRepository {
    suspend fun getAllRepositories() : RepositoryModelDto
}