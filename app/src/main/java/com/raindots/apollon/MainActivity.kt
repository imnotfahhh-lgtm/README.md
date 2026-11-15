package com.raindots.apollon

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(15, 18, 28))
        }

        fun addButton(text: String) {
            val button = TextView(this).apply {
                this.text = text
                textSize = 18f
                setTextColor(Color.WHITE)
                gravity = Gravity.CENTER
                setPadding(20, 24, 20, 24)
                setBackgroundColor(Color.rgb(35, 45, 65))
            }
            layout.addView(button)
        }

        val title = TextView(this).apply {
            text = "RAINDOTS APOLLON"
            textSize = 26f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        layout.addView(title)
        addButton("AI Companion")
        addButton("Structure Finder")
        addButton("Nether Explorer")
        addButton("Coordinates Helper")
        addButton("Survival Assistant")

        setContentView(layout)
    }
}
