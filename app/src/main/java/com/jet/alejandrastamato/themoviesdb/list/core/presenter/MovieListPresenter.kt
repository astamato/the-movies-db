package com.jet.alejandrastamato.themoviesdb.list.core.presenter

import android.view.View
import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel

interface MovieListPresenter {
  fun create()
  fun destroy()
  fun getView(): View
  fun onGetMoviesSuccess(result: MovieListResponseModel)
  fun onGetMoviesFail(it: Throwable?)
}
