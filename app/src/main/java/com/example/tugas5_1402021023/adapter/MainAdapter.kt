package com.example.tugas5_1402021023.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5_1402021023.DetailMovieActivity
import com.example.tugas5_1402021023.R
import com.example.tugas5_1402021023.databinding.ParentItemBinding
import com.example.tugas5_1402021023.model.MainModel
import com.example.tugas5_1402021023.model.MovieModel
import com.example.tugas5_1402021023.utils.SampleData


class MainAdapter(
    private val collection : List<MainModel>,
    private val onMovieItemClickListener: OnMovieItemClickListener
) : RecyclerView.Adapter<MainAdapter.CollectionViewHolder>() {

    interface OnMovieItemClickListener {
        fun onMovieItemClicked(movieModel: MovieModel)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.binding.apply {
            val collection = collection[position]
            tvGenreMovie.text = collection.title
            val movieAdapter = MovieAdapter(collection.movieModel, onMovieItemClickListener)
            rvMovieChild.adapter = movieAdapter
        }
    }

    override fun getItemCount() = collection.size

    inner class CollectionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = ParentItemBinding.bind(itemView)
    }


}