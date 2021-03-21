package com.example.temalaborator

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
            if(stackOfFragments.empty()) {
                exitProcess(0)
            }
            stackOfFragments.pop()
            makeTransaction(stackOfFragments.peek())
        }
        val exitButton: Button = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {
            exitProcess(0)
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