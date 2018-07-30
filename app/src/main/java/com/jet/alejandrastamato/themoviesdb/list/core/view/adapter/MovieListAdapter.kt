package com.jet.alejandrastamato.themoviesdb.list.core.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jakewharton.rxbinding2.view.clicks
import com.jet.alejandrastamato.themoviesdb.R
import com.jet.alejandrastamato.themoviesdb.app.model.Movie
import com.jet.alejandrastamato.themoviesdb.list.core.view.adapter.MovieListAdapter.MovieViewHolder
import io.reactivex.subjects.PublishSubject


class MovieListAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
  val clickEvent = PublishSubject.create<Movie>()!!

  override fun getItemCount(): Int {
    return movies.size
  }

  override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    holder.title.text = movies[position].title
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
    val ticket = LayoutInflater.from(parent.context)
        .inflate(getLayoutToInflate(), parent, false)

    return MovieViewHolder(ticket)
  }

  private fun getLayoutToInflate(): Int {
    return R.layout.movie_item
  }


  inner class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    init {
      itemView.clicks().map { movies[layoutPosition] }.subscribe(clickEvent)
    }

    val title = itemView.findViewById(R.id.title) as TextView

  }

}