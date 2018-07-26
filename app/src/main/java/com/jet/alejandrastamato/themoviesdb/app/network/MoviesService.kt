package com.jet.alejandrastamato.themoviesdb.app.network

import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

  //https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=894343bc55da7fc2cf4e7c22db22a3dc

  @GET("/discover/movie")
  fun getMovieList(@Query("api_key") apiKey: String, @Query("sort_by") sortBy: String): Observable<MovieListResponseModel>

}