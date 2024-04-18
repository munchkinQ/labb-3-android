package com.example.labb_3_android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FinalActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val goHomeButton: Button = findViewById(R.id.backHomeBtn)

        goHomeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    //congratulations on signing up to be a helldiver! Democracy thanks you, hero!!

    //backHomeBtn.setOnClickListener {
    //val intent = Intent(this, MainActivity::class.java)
    //startActivity(intent)
    //}
}