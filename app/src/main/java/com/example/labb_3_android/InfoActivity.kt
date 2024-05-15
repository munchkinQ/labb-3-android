package com.example.labb_3_android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.labb_3_android.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding
    private lateinit var hunterIv: ImageView
    private lateinit var hunterTv: TextView
    private lateinit var biletitanIv: ImageView
    private lateinit var biletitanTv: TextView
    private lateinit var spewerIv: ImageView
    private lateinit var spewerTv: TextView
    private lateinit var botIv: ImageView
    private lateinit var botTv: TextView
    private lateinit var dsIv: ImageView
    private lateinit var dsTv: TextView
    private lateinit var striderIv: ImageView
    private lateinit var striderTv: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toPropagandaButton: Button = findViewById(R.id.toPropagandaBtn)
        val backHome: Button = findViewById(R.id.homeBtn)

        //bots & bugs
        hunterIv = findViewById(R.id.hunterIv)
        hunterTv = findViewById(R.id.hunterTv)
        spewerIv = findViewById(R.id.spewerIv)
        spewerTv = findViewById(R.id.spewerTv)
        biletitanIv = findViewById(R.id.biletitanIv)
        biletitanTv = findViewById(R.id.biletitanTv)
        botIv = findViewById(R.id.botIv)
        botTv = findViewById(R.id.botTv)
        striderIv = findViewById(R.id.striderIv)
        striderTv = findViewById(R.id.striderTv)
        dsIv = findViewById(R.id.dsIv)
        dsTv = findViewById(R.id.dsTv)


        fun loadBugsAndBots(imageView: ImageView, textView: TextView, imageResId: Int, textResId: Int) {
            imageView.setImageResource(imageResId)
            textView.text = getString(textResId)
        }

        loadBugsAndBots(hunterIv, hunterTv, R.drawable.hunter_ii, R.string.hunterTv)
        loadBugsAndBots(spewerIv, spewerTv, R.drawable._171070270_preview_bile_spewer_ii, R.string.spewerTv)
        loadBugsAndBots(biletitanIv, biletitanTv, R.drawable.bile_titan_png, R.string.biletitanTv)
        loadBugsAndBots(botIv, botTv, R.drawable._171070270_preview_commissar_ii2, R.string.botTv)
        loadBugsAndBots(striderIv, striderTv, R.drawable.scout_strider_ii_2, R.string.dsTv)
        loadBugsAndBots(dsIv, dsTv, R.drawable.dropship_ii, R.string.striderTv)

        toPropagandaButton.setOnClickListener {
            val intent = Intent(this, PropagandaActivity::class.java)
            startActivity(intent)
        }

        backHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}