package com.example.xmlparseretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.xmlparseretrofit.databinding.ActivityMainBinding
import com.example.xmlparseretrofit.feedModel.Feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {
    private val myURL = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/"
    private lateinit var binding : ActivityMainBinding
    private lateinit var movieList: ArrayList<Movie>
    private lateinit var adapterObj : Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        fetchData()
        movieList = arrayListOf()
        adapterObj = Adapter(movieList,this)
        binding.mainRV.adapter = adapterObj
        binding.mainRV.layoutManager = GridLayoutManager(this, 2)

    }

    private fun fetchData(){
        val retrofitVar = Retrofit.Builder()
            .baseUrl(myURL).addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val api = retrofitVar.create(API::class.java)
        val request = api.feed

        request!!.enqueue(object : Callback<Feed?> {
            override fun onResponse(call: Call<Feed?>?, response: Response<Feed?>?) {
                    Log.d("MAIN","FEED : ${response!!.body()!!.entrys}")
                val entrys = response!!.body()!!.entrys!!
                for(entry in entrys){
                    movieList.add(Movie(entry.name!!,
                        entry.artist!!,
                        entry.summary!!,
                        entry.price!!,
                        entry.imageUrl!![2].url!!,
                        entry.releaseDate!!.label!!))
                }
                adapterObj.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Feed?>?, t: Throwable?) {
                Log.e("Main", "onFailure: Unable to retrieve RSS: " + t!!.message)
                Toast.makeText(this@MainActivity, "An Error Occurred", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun toDisplayActivity(movie: Movie){
        val toDisplay = Intent(this@MainActivity,DisplayMovieActivity::class.java)
        toDisplay.putExtra("title",movie.title)
        toDisplay.putExtra("summary",movie.summary)
        toDisplay.putExtra("date",movie.date)
        toDisplay.putExtra("image",movie.image)
        toDisplay.putExtra("price",movie.price)
        toDisplay.putExtra("star",movie.star)
        startActivity(toDisplay)

    }
}