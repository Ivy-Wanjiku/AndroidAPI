package com.wanjiku.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val fetchedPosts: List<Post>) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.posts, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val trackPosts = fetchedPosts[position]
        "userId: ${trackPosts.userId.toString()}".also { holder.tvUserId.text = it }
        holder.tvId.text = "Id:${trackPosts.id.toString()}"
        holder.tvTitle.text = trackPosts.title
        holder.tvBody.text = trackPosts.body
    }

    override fun getItemCount(): Int {
        return fetchedPosts.size
    }
}

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvUserId = itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId = itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody = itemView.findViewById<TextView>(R.id.tvBody)
}
