
package com.raindots.apollon

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private fun makeLayout(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(15, 18, 28))
        }
    }

    private fun makeTitle(textValue: String): TextView {
        return TextView(this).apply {
            text = textValue
            textSize = 25f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 30)
        }
    }

    private fun makeButton(textValue: String, action: () -> Unit): Button {
        return Button(this).apply {
            text = textValue
            setOnClickListener { action() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {
        val layout = makeLayout()
        layout.addView(makeTitle("RAINDOTS APOLLON"))

        layout.addView(makeButton("Structure Finder") {
            showStructures()
        })

        layout.addView(makeButton("Nether Explorer") {
            showNether()
        })

        layout.addView(makeButton("About Apollon") {
            Toast.makeText(this, "Your Minecraft companion!", Toast.LENGTH_SHORT).show()
        })

        setContentView(layout)
    }

    private fun showNether() {
        val layout = makeLayout()
        layout.addView(makeTitle("NETHER EXPLORER"))

        val xInput = EditText(this).apply {
            hint = "Overworld X"
            inputType = 8194
        }

        val zInput = EditText(this).apply {
            hint = "Overworld Z"
            inputType = 8194
        }

        val result = TextView(this).apply {
            text = "Nether coordinates appear here"
            textSize = 18f
            setTextColor(Color.WHITE)
            setPadding(0, 20, 0, 20)
        }

        layout.addView(xInput)
        layout.addView(zInput)

        layout.addView(makeButton("Convert Coordinates") {
            val x = xInput.text.toString().toDoubleOrNull()
            val z = zInput.text.toString().toDoubleOrNull()

            if (x != null && z != null) {
                result.text = "Nether X: ${x / 8}\nNether Z: ${z / 8}"
            } else {
                result.text = "Enter valid X and Z."
            }
        })

        layout.addView(result)

        layout.addView(TextView(this).apply {
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
        })

        layout.addView(makeButton("Back to Home") {
            showHome()
        })

        setContentView(layout)
    }

    private fun showStructures() {
        val layout = makeLayout()
        layout.addView(makeTitle("STRUCTURE FINDER"))

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

        layout.addView(selector)

        layout.addView(makeButton("Show Information") {
            info.text = when (selector.selectedItem.toString()) {
                "Village" -> "Explore plains, deserts, savannas and snowy biomes."
                "Ancient City" -> "Search deep underground in the Deep Dark. Beware of the Warden."
                "Stronghold" -> "Use Eyes of Ender to locate a stronghold and its End Portal."
                "Nether Fortress" -> "Look for dark brick bridges and blaze spawners in the Nether."
                "Bastion Remnant" -> "Search the Nether for blackstone structures. Beware of Piglin Brutes."
                "Woodland Mansion" -> "Explore dark forests. Bring strong armor and weapons."
                else -> "Search deep ocean biomes. Watch out for Guardians."
            }
        })

        layout.addView(info)

        layout.addView(makeButton("Back to Home") {
            showHome()
        })

        setContentView(layout)
    }
}
