package com.jet.alejandrastamato.themoviesdb.list.core.view

import android.view.View
import com.jet.alejandrastamato.themoviesdb.app.model.Movie
import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel
import io.reactivex.Observable

interface MovieListView {

  fun getView(): View

  fun showLoading()
  fun hideLoading()

  fun drawMovieList(result: MovieListResponseModel)

  fun showErrorLoading()
  fun onMovieSelected(): Observable<Movie>

  // manage pagination load more data to screen
  fun onLoadMore(): Observable<Boolean>
  fun setLoaded()
}