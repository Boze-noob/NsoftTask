package com.applid.nsofttask.data.api.dto

import com.applid.nsofttask.common.extensions.toMMDDYY
import com.applid.nsofttask.domain.models.RepositoryDetailsModel

data class RepositoryDetailsModelDto(
    val name: String,
    val description: String,
    val language: String,
    val stargazers_count: Int,
    val forks_count: Int,
    val open_issues: Int,
    val watchers_count: Int,
    val owner: RepositoryOwnerModelDto,
    val default_branch: String,
    val created_at: String,
    val updated_at: String,
    val contributors_url: String,
    val contributors: List<RepositoryContributorModelDto>?,
    val html_url : String
)

fun RepositoryDetailsModelDto.toRepositoryDetailsModel(): RepositoryDetailsModel {
    return RepositoryDetailsModel(
        login = owner.login,
        avatarUrl = owner.avatar_url,
        name = name,
        description = description,
        language = language,
        stargazersCount = stargazers_count,
        forksCount = forks_count,
        openIssues = open_issues,
        watchersCount = watchers_count,
        defaultBranch = default_branch,
        createdAt = created_at.toMMDDYY(),
        updatedAt = updated_at.toMMDDYY(),
        contributors = if (!contributors.isNullOrEmpty()) contributors.map { it -> it.toRepositoryContributorModel() } else null,
        htmlUrl = html_url
    )
}