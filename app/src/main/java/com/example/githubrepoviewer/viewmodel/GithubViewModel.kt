package com.example.githubrepoviewer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepoviewer.api.data.GithubRepository
import com.example.githubrepoviewer.api.data.Repository

class GithubViewModel: ViewModel() {

    private val repository = GithubRepository()
    val repositories: LiveData<List<Repository>> = repository.repositories

    fun fetchRepositories(sortBy: String = "created", page: Int = 1) {
        repository.fetchRepositories(sortBy, page)
    }
}