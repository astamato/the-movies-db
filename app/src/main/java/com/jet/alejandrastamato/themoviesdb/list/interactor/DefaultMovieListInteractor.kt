package com.jet.alejandrastamato.themoviesdb.list.interactor

import com.jet.alejandrastamato.themoviesdb.app.model.MovieDetails
import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel
import com.jet.alejandrastamato.themoviesdb.app.network.MoviesService
import io.reactivex.Observable

class DefaultMovieListInteractor(private val service: MoviesService) : MovieListInteractor {
  companion object {
    private const val SERVICE_API_KEY = "894343bc55da7fc2cf4e7c22db22a3dc"
    private const val MOVIE_LIST_DESC_ORDER_DEFAULT = "popularity.desc"
  }

  override fun getMovieList(coinId: Int): Observable<MovieListResponseModel> {
    return service.getMovieList(SERVICE_API_KEY, MOVIE_LIST_DESC_ORDER_DEFAULT)
  }

  override fun getMovieDetails(coinId: Int): Observable<MovieDetails> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}