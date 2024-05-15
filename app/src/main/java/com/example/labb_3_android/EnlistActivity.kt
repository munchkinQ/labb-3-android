package com.example.labb_3_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.labb_3_android.databinding.ActivityEnlistBinding
import com.example.labb_3_android.viewModel.EnlistViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EnlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnlistBinding
    private lateinit var db: DatabaseReference
    private lateinit var viewModel: EnlistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(EnlistViewModel::class.java)
        viewModel.helldiverId.observe(this, Observer { helldiverId ->
            helldiverId?.let {
            }
        })

            db = FirebaseDatabase
                .getInstance("https://labb-3-a7ffb-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference("Helldivers")

            val enlistButton: Button = findViewById(R.id.enlistBtn)
            val isWilling: CheckBox = findViewById(R.id.isWillingToDie)

            enlistButton.setOnClickListener {

                val nameInput: EditText = findViewById(R.id.enlistmentName)
                val ageInput: EditText = findViewById(R.id.enlistmentAge)
                val emailInput: EditText = findViewById(R.id.enlistmentEmail)

                val name: String = nameInput.text.toString().trim()
                val age: String = ageInput.text.toString().trim()
                val email: String = emailInput.text.toString().trim()
                val isWillingToDie: Boolean = isWilling.isChecked

                if (name.length < 2) {
                    nameInput.error =
                        "Super Earth laws stipulate that a name must contain at least 2 letters"
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailInput.error = "Enter a valid supermail address, or face the consequences"
                } else if (!age.matches(Regex("[0-9]+"))) {
                    ageInput.error = "Age *must* be in digits"
                } else {

                    val pushHelldiver = db.push()
                    pushHelldiver.setValue(Helldiver(name, age, email, isWillingToDie))
                        .addOnSuccessListener {
                            val id = pushHelldiver.key
                            viewModel.setHelldiverId(id)

                            Toast.makeText(this, "Added Helldiver", Toast.LENGTH_LONG).show()

                            val intent = Intent(this, TreasonActivity::class.java)
                            intent.putExtra("id", id)
                            startActivity(intent)
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Womp womp: ${e.message}", Toast.LENGTH_LONG)
                                .show()
                        }
                }
            }
        }
    }
