package com.jet.alejandrastamato.themoviesdb.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.jet.alejandrastamato.themoviesdb.R
import com.jet.alejandrastamato.themoviesdb.app.builder.NetworkModule
import com.jet.alejandrastamato.themoviesdb.list.builder.DaggerMovieListComponent
import com.jet.alejandrastamato.themoviesdb.list.builder.MovieListModule
import com.jet.alejandrastamato.themoviesdb.list.core.presenter.MovieListPresenter
import javax.inject.Inject

class MovieListActivity : AppCompatActivity() {
  @Inject
  lateinit var presenter: MovieListPresenter

  lateinit var toolbar: Toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectDependencies()

    presenter.create()
    setContentView(presenter.getView())
    setupToolbar()
  }

  private fun injectDependencies() {
    DaggerMovieListComponent.builder()
        .movieListModule(MovieListModule(this))
        .networkModule(NetworkModule(this)).build()
        .inject(this)
  }


  private fun setupToolbar() {
    toolbar = findViewById(R.id.appToolbar)
    toolbar.title = getString(R.string.movie_list)
    setSupportActionBar(toolbar)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.destroy()
  }
}
