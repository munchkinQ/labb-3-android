package com.example.labb_3_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labb_3_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //main page
        //header that says helldivers
        //logo

        //insert button to next page here

        //toInfoBtn.setOnClickListener {
        //val intent = Intent(this, InfoActivity::class.java)
        //startActivity(intent)
        //}
    }
}