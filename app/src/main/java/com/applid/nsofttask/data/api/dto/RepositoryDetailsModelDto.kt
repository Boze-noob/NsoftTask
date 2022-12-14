package com.applid.nsofttask.data.api.dto

import com.applid.nsofttask.common.extensions.toMMDDYY
import com.applid.nsofttask.common.extensions.value
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
        login = owner.login.value(),
        avatarUrl = owner.avatar_url.value(),
        name = name.value(),
        description = description.value(),
        language = language.value(),
        stargazersCount = stargazers_count,
        forksCount = forks_count,
        openIssues = open_issues,
        watchersCount = watchers_count,
        defaultBranch = default_branch.value(),
        createdAt = created_at.toMMDDYY().value(),
        updatedAt = updated_at.toMMDDYY().value(),
        contributors = if (!contributors.isNullOrEmpty()) contributors.map { it -> it.toRepositoryContributorModel() } else emptyList(),
        htmlUrl = html_url.value()
    )
}