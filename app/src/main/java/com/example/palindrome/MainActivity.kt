package com.example.palindrome

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val viewOutput: TextView = findViewById(R.id.viewOutput)
        val button: Button = findViewById(R.id.button)
        val stringInput: EditText = findViewById(R.id.stringInput)

        button.setOnClickListener {
            val inputText = stringInput.text.toString()

            if(inputText.isBlank()) {
                viewOutput.text = "ОШИБКА! Введите строку для проверки."
                return@setOnClickListener
            }
            val result = isPalindrome(inputText)

            viewOutput.text = if (result) {
                "Строка является палиндромом! :)"
            } else {
                "Строка не является палиндромом"
            }
        }
    }
    private fun isPalindrome(text: String): Boolean {
        val cleanedText = text.filter {it.isLetter()}.lowercase()
        return cleanedText == cleanedText.reversed()
    }
}