package com.applid.nsofttask.domain.models

data class RepositoryModel(
    val login: String,
    val avatarUrl: String,
    val name: String,
    val description: String,
    val language: String,
    val stargazersCount: Int,
    val forksCount: Int,
    val openIssues: Int,
    val watchersCount: Int,
)
