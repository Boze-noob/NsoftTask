package com.applid.nsofttask.data.api.dto

data class RepositoryDetailsModelDto(
    val name : String,
    val description : String,
    val language : String,
    val stargazers_count : Int,
    val forks_count : Int,
    val open_issues : Int,
    val watchers_count : Int,
    val owner : RepositoryOwnerModelDto,
    val default_branch : String,
    val created_at : String,
    val updated_at : String,
    val contributors_url : String,
    val contributors : List<RepositoryContributorsModelDto>?
)