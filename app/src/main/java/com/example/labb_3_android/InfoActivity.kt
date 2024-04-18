package com.example.labb_3_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.labb_3_android.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toPropagandaButton: Button = findViewById(R.id.toPropagandaBtn)

        toPropagandaButton.setOnClickListener {
            val intent = Intent(this, PropagandaActivity::class.java)
            startActivity(intent)
        }
    }

    //info about application
    //only for presentation purposes

    //button

    //toPropagandaBtn.setOnClickListener {
    //val intent = Intent(this, PropagandaActivity::class.java)
    //startActivity(intent)
    //}
}