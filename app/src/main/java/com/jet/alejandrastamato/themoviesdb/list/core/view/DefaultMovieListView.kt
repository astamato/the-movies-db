package com.jet.alejandrastamato.themoviesdb.list.core.view

import android.app.Activity
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.jet.alejandrastamato.themoviesdb.R
import com.jet.alejandrastamato.themoviesdb.app.model.Movie
import com.jet.alejandrastamato.themoviesdb.list.core.view.adapter.MovieListAdapter
import io.reactivex.Observable


class DefaultMovieListView(context: Activity)  : LinearLayout(context), MovieListView {

  private lateinit var adapter: MovieListAdapter

  override fun onMovieSelected(): Observable<Movie> {
    return adapter.clickEvent
  }

  private var progressBar: ProgressBar

  init {
    ConstraintLayout.inflate(context, R.layout.activity_movie_list, this)
    progressBar = findViewById(R.id.progressBar)
  }


  override fun getView(): View {
    return this
  }

  override fun hideLoading() {
    progressBar.visibility = View.INVISIBLE
  }

  override fun showLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun drawMovieList() {
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(context)
    adapter = MovieListAdapter();
    recyclerView.adapter = adapter
  }
}