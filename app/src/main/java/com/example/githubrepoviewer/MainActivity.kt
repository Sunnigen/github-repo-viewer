package com.example.githubrepoviewer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepoviewer.ui.RepoAdapter
import com.example.githubrepoviewer.viewmodel.GithubViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: GithubViewModel by viewModels()
    private lateinit var adapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RepoAdapter()
        recyclerView.adapter = adapter

        viewModel.repositories.observe(this) { repos ->
            if (repos.isNotEmpty()) {
                adapter.submitList(repos)
            } else {
                Toast.makeText(this,"No repositories found!", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.fetchRepositories()

    }
}
