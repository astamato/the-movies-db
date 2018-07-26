package creativehothouse.cryptocurrencyapp.detail.builder

import android.app.Activity
import com.jet.alejandrastamato.themoviesdb.app.builder.ApplicationScope
import com.jet.alejandrastamato.themoviesdb.app.network.MoviesService
import com.jet.alejandrastamato.themoviesdb.list.core.presenter.DefaultMovieListPresenter
import com.jet.alejandrastamato.themoviesdb.list.core.presenter.MovieListPresenter
import com.jet.alejandrastamato.themoviesdb.list.core.view.DefaultMovieListView
import com.jet.alejandrastamato.themoviesdb.list.core.view.MovieListView
import com.jet.alejandrastamato.themoviesdb.list.interactor.DefaultMovieListInteractor
import com.jet.alejandrastamato.themoviesdb.list.interactor.MovieListInteractor


import dagger.Module
import dagger.Provides

@Module
class MovieListModule(val context: Activity) {

  @Provides
  @ApplicationScope
  fun providePresenter(view: MovieListView, interactor: MovieListInteractor
  ): MovieListPresenter {
    return DefaultMovieListPresenter(view, interactor)
  }

  @Provides
  @ApplicationScope
  fun provideView(): MovieListView {
    return DefaultMovieListView(context)
  }

  @Provides
  @ApplicationScope
  fun provideInteractor(service: MoviesService): MovieListInteractor {
    return DefaultMovieListInteractor(service)
  }

}