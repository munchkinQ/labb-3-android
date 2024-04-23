package com.example.labb_3_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.labb_3_android.databinding.ActivityEnlistBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

//import com.google.firebase.database. DatabaseReference

class EnlistActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEnlistBinding
    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //val db = Firebase.firestore

        db = FirebaseDatabase
            .getInstance("https://labb-3-a7ffb-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("Helldivers")

        val enlistButton: Button = findViewById(R.id.enlistBtn)
        val isWilling: View? = findViewById(R.id.isWillingToDie)

        enlistButton.setOnClickListener {

            val nameInput: EditText = findViewById(R.id.enlistmentName)
            val ageInput: EditText = findViewById(R.id.enlistmentAge)
            val emailInput: EditText = findViewById(R.id.enlistmentEmail)


            val name: String = nameInput.text.toString().trim()
            val age: String = ageInput.text.toString().trim()
            val email: String = emailInput.text.toString().trim()

            if (name.isNotEmpty() &&
                age.isNotEmpty() &&
                email.isNotEmpty()) {
                db.push().setValue(Helldiver(name, age, email))
                    .addOnSuccessListener {
                        Toast.makeText(this, "Added Helldiver", Toast.LENGTH_LONG).show()

                        val intent = Intent(this, FinalActivity::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener {e ->
                        Toast.makeText(this, "Womp womp: ${e.message}", Toast.LENGTH_LONG).show()
                    }
            } else {
                Toast.makeText(this, "Please fill in all fields or pay the consequences", Toast.LENGTH_LONG).show()
            }
        }
    }

    //viewbinding on this page

    //insert enlist form here
    //will take in name, age & contact info
    //potentially: also a boolean (maybe a check if i have time?) "are you a patriot"
    //send to firebase
    //if time: snackbox with a oops function
    //if even more time: clicking on the "i changed my mind" will take user to a new page where they are informed they are treasonous and will be persecuted for their crimes against the democracy "no take-backsies"

}