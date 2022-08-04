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
    val owner : Owner
)

data class Owner(
    val avatar_url: String,
    val login: String,
)

fun RepositoryModelDto.toRepositoryModel() : List<RepositoryModel> {

    return items.map { it ->   RepositoryModel(
        login = it.owner.login,
        avatar_url = it.owner.avatar_url,
        name = it.name,
        description = it.description,
        language = it.language,
        stargazers_count = it.stargazers_count,
        forks_count = it.forks_count,
        open_issues = it.open_issues,
        watchers_count = it.watchers_count
    )}

}
