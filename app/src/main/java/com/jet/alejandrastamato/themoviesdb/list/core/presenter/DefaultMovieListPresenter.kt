package com.jet.alejandrastamato.themoviesdb.list.core.presenter

import android.view.View
import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel
import com.jet.alejandrastamato.themoviesdb.list.core.view.MovieListView
import com.jet.alejandrastamato.themoviesdb.list.interactor.MovieListInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

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
    return interactor.getMovieList()
        .subscribeOn(Schedulers.io())
        .doOnSubscribe { view.showLoading() }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { result -> onGetMoviesSuccess(result) },
            { throwable -> onGetMoviesFail(throwable) }
        )
  }

  override fun onGetMoviesSuccess(result: MovieListResponseModel) {
    view.hideLoading()
    view.setLoaded()
    view.drawMovieList(result)
  }

  override fun onGetMoviesFail(it: Throwable?) {
    view.hideLoading()
    view.setLoaded()
    view.showErrorLoading()
  }

  override fun destroy() {
    disposables.clear()
  }

}