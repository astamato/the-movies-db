package com.jet.alejandrastamato.themoviesdb.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.jet.alejandrastamato.themoviesdb.R.layout
import com.jet.alejandrastamato.themoviesdb.list.core.presenter.MovieListPresenter
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.detail.builder.DaggerMovieListComponent
import javax.inject.Inject

//https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=894343bc55da7fc2cf4e7c22db22a3dc

class MovieListActivity : AppCompatActivity() {
  @Inject
  lateinit var presenter: MovieListPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DaggerMovieListComponent.builder()
        .networkModule(NetworkModule(this)).build()
        .inject(this)

    presenter.create()
    setContentView(presenter.getView())
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.destroy()
  }
}
