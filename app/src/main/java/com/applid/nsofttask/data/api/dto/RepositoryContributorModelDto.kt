package com.applid.nsofttask.data.api.dto

import com.applid.nsofttask.domain.models.RepositoryContributorModel

data class RepositoryContributorModelDto(
    val avatar_url: String,
    val contributions: Int,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
)

fun RepositoryContributorModelDto.toRepositoryContributorModel() : RepositoryContributorModel {
    return RepositoryContributorModel(
        avatarUrl = avatar_url,
        login = login
    )
}