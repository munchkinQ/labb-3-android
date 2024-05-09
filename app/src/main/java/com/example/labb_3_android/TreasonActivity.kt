package com.example.labb_3_android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TreasonActivity : AppCompatActivity() {

    private lateinit var db: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treason)

        val backHomeButton: Button = findViewById(R.id.backHomeBtn)
        val header: TextView = findViewById(R.id.treasonHeader)
        val text: TextView = findViewById(R.id.treasonText)
        val helldiverId = intent.getStringExtra("id")

        db = FirebaseDatabase.getInstance("https://labb-3-a7ffb-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("Helldivers")

        helldiverId?.let {id ->
            db.child(id).addListenerForSingleValueEvent(object : ValueEventListener {
                @SuppressLint("SetTextI18n")
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val helldiver = snapshot.getValue(Helldiver::class.java)
                        val name = helldiver?.name ?: "idk"
                        header.text = "Democracy thanks you, $name!"
                    } else {
                        header.text = ""
                    }
                }

                @SuppressLint("SetTextI18n")
                override fun onCancelled(error: DatabaseError) {
                    header.text = "Womp womp: ${error.message}"
                }
            })
        }

        backHomeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}