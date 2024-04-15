package com.example.labb_3_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EnlistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enlist)
    }

    //viewbinding on this page

    //insert enlist form here
    //will take in name, age & contact info
    //potentially: also a boolean (maybe a check if i have time?) "are you a patriot"
    //send to firebase
    //if time: snackbox with a oops function
    //if even more time: clicking on the "i changed my mind" will take user to a new page where they are informed they are treasonous and will be persecuted for their crimes against the democracy "no take-backsies"

    //enlistBtn.setOnClickListener {
    //val intent = Intent(this, FinalActivity::class.java)
    //startActivity(intent)
    //}
}