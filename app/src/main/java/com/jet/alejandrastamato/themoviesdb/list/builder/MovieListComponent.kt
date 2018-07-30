package com.jet.alejandrastamato.themoviesdb.list.builder

import com.jet.alejandrastamato.themoviesdb.app.builder.ApplicationScope
import com.jet.alejandrastamato.themoviesdb.app.network.MoviesService
import com.jet.alejandrastamato.themoviesdb.list.MovieListActivity
import com.jet.alejandrastamato.themoviesdb.app.builder.NetworkModule

import dagger.Component

@ApplicationScope
@Component(modules = [(NetworkModule::class), (MovieListModule::class)])
interface MovieListComponent {
  fun getCryptoCurrenciesService(): MoviesService

  fun inject(activity: MovieListActivity)
}
