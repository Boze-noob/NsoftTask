package com.applid.nsofttask.data.api.dto

import com.applid.nsofttask.domain.models.RepositoryModel

data class RepositoryModelDto(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<Item>
)

data class Item(
    val name : String,
    val description : String,
    val language : String,
    val stargazers_count : Int,
    val forks_count : Int,
    val open_issues : Int,
    val watchers_count : Int,
    val owner : RepositoryOwnerModelDto
)

fun RepositoryModelDto.toRepositoryModel() : List<RepositoryModel> {

    return items.map { it ->   RepositoryModel(
        login = it.owner.login,
        avatarUrl = it.owner.avatar_url,
        name = it.name,
        description = it.description,
        language = it.language,
        stargazersCount = it.stargazers_count,
        forksCount = it.forks_count,
        openIssues = it.open_issues,
        watchersCount = it.watchers_count
    )}

}
