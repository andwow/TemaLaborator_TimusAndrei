package com.example.temalaborator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val staticFragment: FirstFragment = FirstFragment("A1F1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val continueButton: Button = findViewById(R.id.continue_button)
        continueButton.setOnClickListener {
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.first_fragment, staticFragment)
        transaction.commit()
    }
}