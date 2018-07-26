package creativehothouse.cryptocurrencyapp.detail.builder

import com.jet.alejandrastamato.themoviesdb.app.builder.ApplicationScope
import com.jet.alejandrastamato.themoviesdb.app.network.MoviesService
import com.jet.alejandrastamato.themoviesdb.list.MovieListActivity
import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.detail.CoinDetailsActivity
import dagger.Component
import io.realm.Realm

@ApplicationScope
@Component(modules = [(NetworkModule::class), (MovieListModule::class)])
interface MovieListComponent {
  fun getCryptoCurrenciesService(): MoviesService

  fun inject(activity: MovieListActivity)
}
