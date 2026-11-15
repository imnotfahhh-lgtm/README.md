package com.raindots.apollon

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(15, 18, 28))
        }

        val title = TextView(this).apply {
            text = "APOLLON AI"
            textSize = 26f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val chat = TextView(this).apply {
            text = "Apollon: Hey! Ready to explore Minecraft?"
            textSize = 17f
            setTextColor(Color.WHITE)
            setPadding(12, 30, 12, 30)
        }

        val input = EditText(this).apply {
            hint = "Ask Apollon..."
            setTextColor(Color.WHITE)
            setHintTextColor(Color.LTGRAY)
        }

        val send = Button(this).apply {
            text = "Send"
            setOnClickListener {
                val question = input.text.toString()
                if (question.isNotBlank()) {
                    chat.text = "You: $question\n\nApollon: I'm here to help with Minecraft!"
                    input.text.clear()
                }
            }
        }

        layout.addView(title)
        layout.addView(chat)
        layout.addView(input)
        layout.addView(send)

        setContentView(layout)
    }
}
