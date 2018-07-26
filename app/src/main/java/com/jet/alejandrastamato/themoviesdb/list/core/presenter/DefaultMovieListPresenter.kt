package com.jet.alejandrastamato.themoviesdb.list.core.presenter

import android.view.View
import com.jet.alejandrastamato.themoviesdb.list.core.view.MovieListView
import com.jet.alejandrastamato.themoviesdb.list.interactor.MovieListInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DefaultMovieListPresenter(private var view: MovieListView,
    private var interactor: MovieListInteractor) : MovieListPresenter {

  private var disposables = CompositeDisposable()

  override fun getView(): View {
    return view.getView()
  }

  override fun create() {
    disposables.add(this.observeGetMovies()!!)
  }

  private fun observeGetMovies(): Disposable? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onGetMoviesSuccess() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onGetMoviesFail(it: Throwable?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun destroy() {
    disposables.clear()
  }

}