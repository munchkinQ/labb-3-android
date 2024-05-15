package com.example.labb_3_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.labb_3_android.vm.EnlistViewModel
import com.example.labb_3_android.databinding.ActivityEnlistBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EnlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnlistBinding
    private lateinit var db: DatabaseReference
    private var helldiverId: String? = null
    private lateinit var viewModel: EnlistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[EnlistViewModel::class.java]
        viewModel.helldiverId?.let { helldiverId ->
            this.helldiverId = helldiverId

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
                            Toast.makeText(this, "Added Helldiver", Toast.LENGTH_LONG).show()

                            viewModel.helldiverId = pushHelldiver.key

                            val intent = Intent(this, TreasonActivity::class.java)
                            intent.putExtra("id", helldiverId)
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
}