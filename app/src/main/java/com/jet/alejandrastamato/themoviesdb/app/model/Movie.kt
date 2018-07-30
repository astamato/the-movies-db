package com.jet.alejandrastamato.themoviesdb.app.model

import com.google.gson.annotations.SerializedName
import java.util.Date

//https://image.tmdb.org/t/p/w600_and_h900_bestv2/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg
//https://image.tmdb.org/t/p/w600_and_h900_bestv2/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg

data class Movie(@SerializedName("original_title") val originalTitle: String,
    val title: String,
    @SerializedName("poster_path") val imageURL: String,
    @SerializedName("original_language") val originalLanguage: String,
    val overview: String,
    @SerializedName("release_date") val release_date: Date
)