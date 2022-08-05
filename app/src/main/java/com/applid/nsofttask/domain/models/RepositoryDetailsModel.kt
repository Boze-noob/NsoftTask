package com.applid.nsofttask.domain.models

data class RepositoryDetailsModel(
    val login : String,
    val avatarUrl : String,
    val name : String,
    val description : String,
    val language : String,
    val stargazersCount : Int,
    val forksCount : Int,
    val openIssues : Int,
    val watchersCount : Int,
    val defaultBranch : String,
    val createdAt : String,
    val updatedAt : String,
    val contributors : List<ContributorsModel>
)
