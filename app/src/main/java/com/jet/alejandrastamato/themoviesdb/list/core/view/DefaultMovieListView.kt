package com.jet.alejandrastamato.themoviesdb.list.core.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.jet.alejandrastamato.themoviesdb.R
import com.jet.alejandrastamato.themoviesdb.app.model.Movie
import com.jet.alejandrastamato.themoviesdb.app.model.MovieListResponseModel
import com.jet.alejandrastamato.themoviesdb.list.core.view.adapter.MovieListAdapter
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class DefaultMovieListView(context: Context) : LinearLayout(context), MovieListView {

  val clickOnLoadMore = PublishSubject.create<Boolean>()!!
  private var layoutManager: LinearLayoutManager
  private val visibleThreshold = 5
  private var loading: Boolean = false

  private lateinit var adapter: MovieListAdapter


  override fun getView(): View {
    return this
  }

  override fun onMovieSelected(): Observable<Movie> {
    return adapter.clickEvent
  }

  private var progressBar: ProgressBar

  init {
    ConstraintLayout.inflate(context, R.layout.activity_movie_list, this)
    progressBar = findViewById(R.id.progressBar)
    layoutManager = LinearLayoutManager(context)
  }

  override fun hideLoading() {
    progressBar.visibility = View.INVISIBLE
  }

  override fun showLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun drawMovieList(result: MovieListResponseModel) {
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(context)
    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
      override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val totalItemCount = layoutManager.itemCount
        val lastVisibleItem = layoutManager
            .findLastVisibleItemPosition()
        if (!loading
            && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
          clickOnLoadMore.onNext(true)
          loading = true
        }
      }
    })
    adapter = MovieListAdapter(result.results)
    recyclerView.adapter = adapter
  }

  override fun setLoaded() {
    loading = false
  }

  override fun onLoadMore(): Observable<Boolean> {
    return clickOnLoadMore
  }

  override fun showErrorLoading() {
    val container = getView().findViewById(R.id.coordinatorLayout) as ViewGroup
    Snackbar.make(container
        , R.string.onErrorLoad, Snackbar.LENGTH_LONG)
        .show()
  }
}