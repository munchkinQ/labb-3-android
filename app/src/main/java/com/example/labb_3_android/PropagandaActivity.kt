package com.example.labb_3_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PropagandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propaganda)
    }

    //API on this page
    //api: https://helldiverstrainingmanual.com/api/v1/war/campaign
    //maybe
    //taken from: https://helldiverstrainingmanual.com/api

    //Take Me There!!! --> (to enlist screen)
    //toEnlistBtn.setOnClickListener {
    //val intent = Intent(this, EnlistActivity::class.java)
    //startActivity(intent)
    //}
}