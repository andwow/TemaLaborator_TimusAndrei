package com.example.temalaborator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class SecondActivity : AppCompatActivity() {
    private val arrayOfFragments:ArrayList<SecondFragment> = ArrayList<SecondFragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val initialFragment: SecondFragment = SecondFragment("A2F1")
        makeTransaction(initialFragment)
        arrayOfFragments.add(initialFragment)
        val continueButton: Button = findViewById(R.id.continue_button_second)
        continueButton.setOnClickListener {
            val currentPosition: Int = arrayOfFragments.size
            val nextPosition: Int = currentPosition + 1
            val text: String = "A2F$nextPosition"
            val nextFragment: SecondFragment = SecondFragment(text)
            arrayOfFragments.add(nextFragment)
            makeTransaction(arrayOfFragments[currentPosition])
        }
        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            val currentPosition: Int = arrayOfFragments.size - 1
            if(currentPosition == 0) {
                exitProcess(1)
            }
            val forwardPosition: Int = currentPosition - 1;
            arrayOfFragments.removeAt(currentPosition)
            makeTransaction(arrayOfFragments[forwardPosition])
        }
        val exitButton: Button = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {
            exitProcess(1)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        arrayOfFragments.clear()
    }
    private fun makeTransaction(fragment: SecondFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.second_fragment, fragment)
        transaction.commit()
    }
}