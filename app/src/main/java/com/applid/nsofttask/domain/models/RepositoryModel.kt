package com.applid.nsofttask.domain.models

data class RepositoryModel(
    val login : String,
    val avatar_url : String,
    val name : String,
    val description : String,
    val language : String,
    val stargazers_count : Int,
    val forks_count : Int,
    val open_issues : Int,
    val watchers_count : Int,
)
