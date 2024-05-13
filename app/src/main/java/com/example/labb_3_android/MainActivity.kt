package com.example.labb_3_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.labb_3_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonToInfo: Button = findViewById(R.id.toInfoBtn)
        val buttonToPropaganda: Button = findViewById(R.id.toPropaganda)
        val buttonToEnlist: Button = findViewById(R.id.toEnlist)

        buttonToInfo.setOnClickListener {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
        }
        buttonToPropaganda.setOnClickListener {
            val intent = Intent(this, PropagandaActivity::class.java)
            startActivity(intent)
        }

        buttonToEnlist.setOnClickListener {
            val intent3 = Intent(this, EnlistActivity::class.java)
            startActivity(intent3)
        }
    }
}