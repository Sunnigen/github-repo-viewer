package com.example.githubrepoviewer.api.data

data class RepoResponse(
    val items: List<Repository>
)

data class Repository(
    val id: Long,
    val name: String,
    val owner: Owner?,
    val stargazers_count: Int,
    val language: String
)

data class Owner(
    val login: String?,
    val avatar_url: String?,
)
