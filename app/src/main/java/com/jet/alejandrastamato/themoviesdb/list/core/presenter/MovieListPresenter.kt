package com.jet.alejandrastamato.themoviesdb.list.core.presenter

import android.view.View

interface MovieListPresenter {
  fun create()
  fun destroy()
  fun getView(): View
  fun onGetMoviesSuccess()
  fun onGetMoviesFail(it: Throwable?)
}
