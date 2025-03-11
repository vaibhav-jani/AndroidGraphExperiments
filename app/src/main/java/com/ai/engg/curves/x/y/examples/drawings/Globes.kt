package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.conic.sections.Ellipse
import com.ai.engg.curves.drawings.globe.Globe
import com.ai.engg.curves.models.Drawing

fun getPlanets(): List<Drawing> {
    val drawings = arrayListOf<Drawing>()

    drawings.add(Globe(-3f, 24f, 4f))
    drawings.add(Globe(0f, 20f, 5f))
    drawings.add(Globe(5f, 15f, 6f))

    drawings.add(Globe(0f, 0f, 10f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.88f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.84f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.80f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.76f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.72f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.68f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.64f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.60f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.56f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.52f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.48f))
    drawings.add(Ellipse(0f, 0f, 10f, 10f, 1.44f))

    drawings.add(Globe(-20f, -20f, 15f))
    drawings.add(Globe(-37f, -35f, 9f))
    drawings.add(Globe(-42f, -45f, 7f))

    return drawings
}

fun getColoredPlanets(): List<Drawing> {

    val drawings = arrayListOf<Drawing>()

    val globe0 = Globe(-3f, 24f, 4f)
    globe0.setColor("#00f0ff")
    drawings.add(globe0)

    val globe1 = Globe(0f, 20f, 5f).apply { setColor("#994500") } // Vibrant Orange-Red
    drawings.add(globe1)
    drawings.add(Globe(5f, 15f, 6f).apply { setColor("#32cd32") }) // Lime Green

    val globe10 = Globe(0f, 0f, 10f).apply { setColor("#ffdd00") } // Dodger Blue
    drawings.add(globe10)

    val ellipse1 = Ellipse(0f, 0f, 10f, 10f, 1.88f).apply { setColor("#ff69b4") } // Hot Pink
    drawings.add(ellipse1)
    val ellipse2 = Ellipse(0f, 0f, 10f, 10f, 1.84f).apply { setColor("#8a2be2") } // Blue Violet
    drawings.add(ellipse2)
    val ellipse3 = Ellipse(0f, 0f, 10f, 10f, 1.80f).apply { setColor("#00ff7f") } // Spring Green
    drawings.add(ellipse3)
    val ellipse4 = Ellipse(0f, 0f, 10f, 10f, 1.76f).apply { setColor("#00ced1") } // Dark Turquoise
    drawings.add(ellipse4)
    val ellipse5 = Ellipse(0f, 0f, 10f, 10f, 1.72f).apply { setColor("#ffa500") } // Orange
    drawings.add(ellipse5)
    val ellipse6 = Ellipse(0f, 0f, 10f, 10f, 1.68f).apply { setColor("#ff1493") } // Deep Pink
    drawings.add(ellipse6)
    val ellipse7 = Ellipse(0f, 0f, 10f, 10f, 1.64f).apply { setColor("#800080") } // Purple
    drawings.add(ellipse7)
    val ellipse8 = Ellipse(0f, 0f, 10f, 10f, 1.60f).apply { setColor("#dc143c") } // Crimson
    drawings.add(ellipse8)
    val ellipse9 = Ellipse(0f, 0f, 10f, 10f, 1.56f).apply { setColor("#ff6347") } // Tomato
    drawings.add(ellipse9)
    val ellipse10 = Ellipse(0f, 0f, 10f, 10f, 1.52f).apply { setColor("#00bfff") } // Deep Sky Blue
    drawings.add(ellipse10)
    val ellipse11 = Ellipse(0f, 0f, 10f, 10f, 1.48f).apply { setColor("#4b0082") } // Indigo
    drawings.add(ellipse11)
    val ellipse12 =
        Ellipse(0f, 0f, 10f, 10f, 1.44f).apply { setColor("#20b2aa") } // Light Sea Green
    drawings.add(ellipse12)

    val globe = Globe(-20f, -20f, 15f).apply { setColor("#ff4000") } // Golden Yellow
    drawings.add(globe)

    val globe2 = Globe(-37f, -35f, 9f).apply { setColor("#00ff00") } // Bright Green
    drawings.add(globe2)

    val globe3 = Globe(-42f, -45f, 7f)
    globe3.apply { setColor("#fb0000") }
    drawings.add(globe3) // Dark Red

    return drawings
}

fun getSinglePlanet(): List<Drawing> {

    val drawings = ArrayList<Drawing>()
    drawings.add(Globe(0f, 0f, 10f))

    return drawings
}