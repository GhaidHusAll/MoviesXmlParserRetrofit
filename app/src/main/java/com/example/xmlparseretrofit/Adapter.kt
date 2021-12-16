package com.example.xmlparseretrofit

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparseretrofit.databinding.ItemBinding
import android.graphics.BitmapFactory
import com.squareup.picasso.Picasso

import java.net.URL





class Adapter(private val movies: ArrayList<Movie>, val activity: Activity):RecyclerView.Adapter<Adapter.Holder>() {
    class Holder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       return Holder(ItemBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val movie = movies[position]
       holder.binding.apply {
           tvTitle.text = movie.title
           Picasso.get().load(movie.image).into(ivPoster)
       }
        holder.binding.mainCV.setOnClickListener {
            (activity as MainActivity).toDisplayActivity(movie)
        }
    }

    override fun getItemCount() = movies.size
}