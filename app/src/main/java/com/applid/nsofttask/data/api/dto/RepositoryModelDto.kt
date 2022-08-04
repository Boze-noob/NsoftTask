package com.applid.nsofttask.data.api.dto

import com.applid.nsofttask.domain.models.RepositoryModel

data class RepositoryModelDto(
    val repositoryOwnerModelDto: RepositoryOwnerModelDto,
    val name : String,
    val description : String,
    val language : String,
    val stargazers_count : Int,
    val forks_count : Int,
    val open_issues : Int,
    val watchers_count : Int,
)

fun RepositoryModelDto.toRepositoryModel() : RepositoryModel {
    return RepositoryModel(
        login = repositoryOwnerModelDto.login,
        avatar_url = repositoryOwnerModelDto.avatar_url,
        name = name,
        description = description,
        language = language,
        stargazers_count = stargazers_count,
        forks_count = forks_count,
        open_issues = open_issues,
        watchers_count = watchers_count
    )
}
