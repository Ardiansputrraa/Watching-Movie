package com.example.tugas5_1402021023.utils

import com.example.tugas5_1402021023.model.MainModel
import com.example.tugas5_1402021023.model.MovieModel

object SampleData {

    val movieModel= listOf(
        MovieModel(Images.imageUrl0),
        MovieModel(Images.imageUrl1),
        MovieModel(Images.imageUrl2),
        MovieModel(Images.imageUrl3),
        MovieModel(Images.imageUrl4),
        MovieModel(Images.imageUrl5),
        MovieModel(Images.imageUrl6),
        MovieModel(Images.imageUrl7)
    )

    val collections = listOf(
        MainModel("All Movie" , movieModel),
        MainModel("Want to see" , movieModel.reversed()),
        MainModel("Popular Movie" , movieModel.shuffled()),
        MainModel("Top Rated Movie" , movieModel)
    )

}