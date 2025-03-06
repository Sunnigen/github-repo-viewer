package com.example.githubrepoviewer.api.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiInterface {
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") query: String = "stars:>0",
        @Query("sort") sort: String = "created",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
    ): Call<RepoResponse>
}