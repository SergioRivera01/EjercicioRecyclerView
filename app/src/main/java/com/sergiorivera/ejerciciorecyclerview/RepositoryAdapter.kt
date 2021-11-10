package com.sergiorivera.ejerciciorecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RepositoryAdapter(private val repositories: MutableList<Repository>,
                                 val onClickListener: (Repository) -> Unit): RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>(){

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view : View = layoutInflater.inflate(R.layout.item_repository, parent, false)
            return RepositoryViewHolder(view)
    }
     override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository : Repository = repositories[position]

        holder.tv_name.text = repository.name
        holder.tv_tags.text = repository.owner
        Glide.with(holder.iv_icon.context).load(repository.image).into(holder.iv_icon)

        holder.itemView.setOnClickListener{
            onClickListener(repository)
        }
    }


        class RepositoryViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            var tv_name : TextView = view.findViewById(R.id.tv_name)
            var tv_tags : TextView = view.findViewById(R.id.tv_Tags)
            var iv_icon :  ImageView = view.findViewById(R.id.iv_user)

        }

    override fun getItemCount(): Int {
        return  repositories.size
    }


}


