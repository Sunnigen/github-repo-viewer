package com.example.githubrepoviewer.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepoviewer.R
import com.example.githubrepoviewer.api.data.Repository

class RepoAdapter: RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private var repoList: List<Repository> = emptyList()

    class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoName: TextView = view.findViewById(R.id.repoName)
        val repoOwner: TextView = view.findViewById(R.id.repoOwner)
        val repoStars: TextView = view.findViewById(R.id.repoStars)
        val repoOwnerAvatar: ImageView = view.findViewById(R.id.repoOwnerAvatar)
        val languagesUsed: TextView = view.findViewById(R.id.langaugesUsed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val repoView = LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent, false)
        return RepoViewHolder(repoView)
    }

    override fun getItemCount(): Int = repoList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repoList[position]

        holder.repoName.text = repo.name
        holder.repoOwner.text = "By: ${repo.owner?.login}"
        holder.repoStars.text = "⭐ ${repo.stargazers_count}"
        holder.languagesUsed.text = repo.language

        Glide.with(holder.itemView.context)
            .load(repo.owner?.avatar_url)
            .into(holder.repoOwnerAvatar)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<Repository>) {
        repoList = newList
        notifyDataSetChanged()
    }


}

