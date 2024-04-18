package com.example.labb_3_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        val buttonToInfo: Button = findViewById(R.id.toInfoBtn)
        //insert button to next page here

        buttonToInfo.setOnClickListener {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
        }
    }
}