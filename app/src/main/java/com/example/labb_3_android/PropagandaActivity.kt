package com.example.labb_3_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.labb_3_android.api.NewsApi
import com.example.labb_3_android.api.NewsItem
import com.example.labb_3_android.databinding.ActivityPropagandaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("war/news")
    fun getNews(): Call<List<NewsItem>>
}


class PropagandaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropagandaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //viewbinding setup
        binding = ActivityPropagandaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://helldiverstrainingmanual.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //getter
        val getNewsItem = retrofit.create<NewsApi>().getNews()

        //button
        val enlistButton: Button = findViewById(R.id.toEnlistBtn)
        val homeButton: Button = findViewById(R.id.backHome)

        //listener
        enlistButton.setOnClickListener {
            val intent = Intent(this, EnlistActivity::class.java)
            startActivity(intent)
        }

        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        getNewsItem.enqueue(object : Callback<List<NewsItem>> {
            override fun onResponse(call: Call<List<NewsItem>>, response: Response<List<NewsItem>>) {

                if (response.isSuccessful) {
                    val news = response.body()
                    if (news != null && news.isNotEmpty()) {
                        binding.propagandaText.text = news[0].message
                    }
                }

            }
            override fun onFailure(call: Call<List<NewsItem>>, t: Throwable) {
                println(t.message)

            }
        })

    }

    //API on this page
    //api: https://helldiverstrainingmanual.com/api/v1/war/news
    //maybe
    //taken from: https://helldiverstrainingmanual.com/api

    //Take Me There!!! --> (to enlist screen)
    //toEnlistBtn.setOnClickListener {
    //val intent = Intent(this, EnlistActivity::class.java)
    //startActivity(intent)
    //}
}