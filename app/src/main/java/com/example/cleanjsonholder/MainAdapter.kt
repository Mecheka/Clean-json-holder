package com.example.cleanjsonholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanjsonholder.databinding.PostsItemBinding
import com.example.domain.entities.PostsEntity

class MainAdapter(private val posts: List<PostsEntity>):
    RecyclerView.Adapter<MainAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.textTitle.text = posts[position].title
        holder.textBody.text = posts[position].body
    }

    override fun getItemCount() = posts.size

    inner class PostsViewHolder(binding: PostsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val textTitle: TextView = binding.textTitle
        val textBody: TextView = binding.textBody
    }
}