
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
            text = "STRUCTURE FINDER"
            textSize = 25f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val structures = arrayOf(
            "Village",
            "Ancient City",
            "Stronghold",
            "Nether Fortress",
            "Bastion Remnant",
            "Woodland Mansion",
            "Ocean Monument"
        )

        val info = TextView(this).apply {
            text = "Choose a structure to learn about it."
            textSize = 17f
            setTextColor(Color.WHITE)
            setPadding(8, 24, 8, 24)
        }

        val selector = Spinner(this).apply {
            adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                structures
            )
        }

        val showInfo = Button(this).apply {
            text = "Show Information"
            setOnClickListener {
                info.text = when (selector.selectedItem.toString()) {
                    "Village" -> "Explore plains, deserts, savannas and snowy biomes."
                    "Ancient City" -> "Search deep underground in the Deep Dark biome. Watch out for the Warden."
                    "Stronghold" -> "Use Eyes of Ender to locate a stronghold and its End Portal."
                    "Nether Fortress" -> "Explore the Nether. Look for dark brick bridges and blaze spawners."
                    "Bastion Remnant" -> "Search the Nether for large blackstone structures. Beware of Piglin Brutes."
                    "Woodland Mansion" -> "Explore dark forests. Bring strong armor and weapons."
                    else -> "Search deep ocean biomes. Watch out for Guardians."
                }
            }
        }

        layout.addView(title)
        layout.addView(selector)
        layout.addView(showInfo)
        layout.addView(info)

        setContentView(layout)
    }
}
