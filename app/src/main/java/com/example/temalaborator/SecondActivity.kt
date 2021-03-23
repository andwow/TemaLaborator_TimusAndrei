package com.example.temalaborator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*
import kotlin.system.exitProcess

class SecondActivity : AppCompatActivity() {
    private val stackOfFragments: Stack<SecondFragment> = Stack<SecondFragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val initialFragment = SecondFragment("A2F1")
        makeTransaction(initialFragment)
        stackOfFragments.push(initialFragment)
        val continueButton: Button = findViewById(R.id.continue_button_second)
        continueButton.setOnClickListener {
            val currentPosition: Int = stackOfFragments.size
            val nextPosition: Int = currentPosition + 1
            val text = "A2F$nextPosition"
            val nextFragment = SecondFragment(text)
            stackOfFragments.push(nextFragment)
            makeTransaction(stackOfFragments.peek())
        }
        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            if(stackOfFragments.size == 1) {
                finish()
            } else {
                stackOfFragments.pop()
                makeTransaction(stackOfFragments.peek())
            }
        }
        val exitButton: Button = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        stackOfFragments.clear()
    }
    private fun makeTransaction(fragment: SecondFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.second_fragment, fragment)
        transaction.commit()
    }
}