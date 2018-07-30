package com.jet.alejandrastamato.themoviesdb.app.model

import com.google.gson.annotations.SerializedName

data class MovieListResponseModel(
    val results: ArrayList<Movie>, val page: Int,
    @SerializedName("total_results") val itemsPerPage: Int,
    @SerializedName("total_pages") val totalPages: Int
)