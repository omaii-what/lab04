package com.example.lab04

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var isIndicatorVisible = true
    private var isCenterButtonActive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redButton: Button = findViewById(R.id.redButton)
        val blueButton: Button = findViewById(R.id.blueButton)
        val yellowButton: Button = findViewById(R.id.yellowButton)
        val greenButton: Button = findViewById(R.id.greenButton)
        val statusIndicator: View = findViewById(R.id.statusIndicator)
        val statusText: View = findViewById(R.id.statusText)
        val messageText: TextView = findViewById(R.id.messageText)

        redButton.setOnClickListener {
            statusIndicator.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            messageText.text = "Активирован красный режим"
            messageText.setTextColor(getColor(android.R.color.holo_red_dark))
            Toast.makeText(this, "Красный активирован", Toast.LENGTH_SHORT).show()
        }

        blueButton.setOnClickListener {
            statusIndicator.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            messageText.text = "Активирован синий режим"
            messageText.setTextColor(getColor(android.R.color.holo_blue_dark))
            Toast.makeText(this, "Синий активирован", Toast.LENGTH_SHORT).show()
        }

        yellowButton.setOnClickListener {
            if (isCenterButtonActive) {
                yellowButton.text = "Неактивно"
                yellowButton.backgroundTintList = getColorStateList(android.R.color.darker_gray)
                messageText.text = "Центральная кнопка деактивирована"
            } else {
                yellowButton.text = "Центр"
                yellowButton.backgroundTintList =
                    getColorStateList(android.R.color.holo_orange_dark)
                messageText.text = "Центральаня кнпока активирована"
            }
            isCenterButtonActive = !isCenterButtonActive
        }

        greenButton.setOnClickListener {
            if (isIndicatorVisible) {
                statusIndicator.visibility = View.INVISIBLE
                statusText.text = "Статус: Скрыт"
                messageText.text = "Индикатор скрыт"
            } else {
                statusIndicator.visibility = View.VISIBLE
                statusText.text = "Статус: Виден"
                messageText.text = "Индикатор показан"
            }
            isIndicatorVisible = !isIndicatorVisible
        }
    }
}