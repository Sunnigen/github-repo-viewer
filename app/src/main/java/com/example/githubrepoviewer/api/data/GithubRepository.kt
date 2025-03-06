package com.example.githubrepoviewer.api.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class GithubRepository {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> =_repositories

    fun fetchRepositories(sortBy: String = "created", page: Int = 1){
        RetrofitInstance.api.getRepositories(sort = sortBy, page = page).enqueue(
            object: Callback<RepoResponse> {
                override fun onResponse(
                    call: Call<RepoResponse>,
                    response: Response<RepoResponse>
                ) {
                    if (response.isSuccessful) {
                        _repositories.postValue(response.body()?.items ?: emptyList())
                    } else {
                        Log.e("GithubRepository", "API Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                    Log.e("GithubRepository", "API Error onFailure: ${t.message}")
                }

            }
        )
    }


}