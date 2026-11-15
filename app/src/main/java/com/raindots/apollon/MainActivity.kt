package com.raindots.apollon

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(15, 18, 28))
        }

        val title = TextView(this).apply {
            text = "NETHER EXPLORER"
            textSize = 25f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val overworldX = EditText(this).apply {
            hint = "Overworld X"
            inputType = 2
        }

        val overworldZ = EditText(this).apply {
            hint = "Overworld Z"
            inputType = 2
        }

        val result = TextView(this).apply {
            text = "Nether coordinates will appear here"
            textSize = 18f
            setTextColor(Color.WHITE)
        }

        val calculate = Button(this).apply {
            text = "Convert Coordinates"
            setOnClickListener {
                val x = overworldX.text.toString().toDoubleOrNull()
                val z = overworldZ.text.toString().toDoubleOrNull()

                if (x != null && z != null) {
                    result.text = "Nether X: ${x / 8}\nNether Z: ${z / 8}"
                } else {
                    result.text = "Enter valid X and Z coordinates."
                }
            }
        }

        val tips = TextView(this).apply {
            text = """
                NETHER SURVIVAL TIPS

                • Bring fire resistance potions.
                • Carry gold armor.
                • Watch out for lava.
                • Mark your portal coordinates.
                • Look for fortresses for blaze rods.
            """.trimIndent()
            textSize = 17f
            setTextColor(Color.WHITE)
        }

        layout.addView(title)
        layout.addView(overworldX)
        layout.addView(overworldZ)
        layout.addView(calculate)
        layout.addView(result)
        layout.addView(tips)

        setContentView(layout)
    }
}
