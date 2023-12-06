package com.example.tugas5_1402021023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas5_1402021023.adapter.MainAdapter
import com.example.tugas5_1402021023.databinding.ActivityMainBinding
import com.example.tugas5_1402021023.model.MovieModel
import com.example.tugas5_1402021023.utils.SampleData

class MainActivity : AppCompatActivity(), MainAdapter.OnMovieItemClickListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainAdapter = MainAdapter(SampleData.collections, this)
        binding.rvMain.adapter = mainAdapter
    }

    override fun onMovieItemClicked(movieModel: MovieModel) {
        // Tambahkan kode untuk berpindah ke Activity lain dengan data yang diperlukan
        val intent = Intent(this, DetailMovieActivity::class.java).also {
            it.putExtra("imgUrl", movieModel.imageUrl)
        }
        startActivity(intent)
    }
}