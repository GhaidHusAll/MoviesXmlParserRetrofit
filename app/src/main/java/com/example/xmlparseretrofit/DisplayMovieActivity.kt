package com.example.xmlparseretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xmlparseretrofit.databinding.ActivityDisplayMovieBinding
import com.squareup.picasso.Picasso

class DisplayMovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDisplayMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setData()
    }

    fun setData(){

        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvSummary.text = intent.getStringExtra("summary")
        binding.tvStar.text = intent.getStringExtra("star")
        binding.tvDate.text = intent.getStringExtra("date")
        binding.tvPrice.text = intent.getStringExtra("price")
        Picasso.get().load(intent.getStringExtra("image")).into(binding.imageView)



    }
}