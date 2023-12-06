package com.example.tugas5_1402021023.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tugas5_1402021023.DetailMovieActivity
import com.example.tugas5_1402021023.R
import com.example.tugas5_1402021023.databinding.MovieItemBinding
import com.example.tugas5_1402021023.model.MovieModel
import com.example.tugas5_1402021023.utils.SampleData

class MovieAdapter (private val movieModel: List<MovieModel>,
                    private val onMovieItemClickListener: MainAdapter.OnMovieItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieModel[position]
        holder.binding.apply {
            imgMoviePoster.load(movie.imageUrl)
        }
        holder.itemView.setOnClickListener {
            onMovieItemClickListener.onMovieItemClicked(movie)
        }
    }

    override fun getItemCount() = movieModel.size


    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = MovieItemBinding.bind(itemView)

    }

}