package com.jet.alejandrastamato.themoviesdb.list.interactor

import com.jet.alejandrastamato.themoviesdb.app.model.MovieDetails
import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel
import io.reactivex.Observable

interface MovieListInteractor {

  fun getMovieList(coinId: Int): Observable<MovieListResponseModel>

  fun getMovieDetails(coinId: Int): Observable<MovieDetails>

}