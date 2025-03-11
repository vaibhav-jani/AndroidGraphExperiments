package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.conic.sections.Circle
import com.ai.engg.curves.drawings.conic.sections.Ellipse
import com.ai.engg.curves.drawings.conic.sections.Hyperbola
import com.ai.engg.curves.drawings.conic.sections.Parabola
import com.ai.engg.curves.drawings.globe.Globe
import com.ai.engg.curves.drawings.trigmometric.CosCurve
import com.ai.engg.curves.drawings.trigmometric.SinCurve
import com.ai.engg.curves.drawings.trigmometric.TanCurve
import com.ai.engg.curves.models.Curve
import com.ai.engg.curves.models.CurveAttributes
import com.ai.engg.curves.models.Drawing
import com.ai.engg.curves.models.Point
import kotlin.math.cos
import kotlin.math.sin

fun getRingOfLines(): List<Drawing> {
    val points = ArrayList<Point>()

    var i = 0f
    while (i < 360f) {

        // Proper circle with dots
        // val x = 5 * cos(Math.toRadians(i.toDouble())).toFloat()
        // val y = 5 * sin(Math.toRadians(i.toDouble())).toFloat()

        // Set of lines forming a ring
        val x = 5 * cos(i.toDouble()).toFloat()
        val y = 5 * sin(i.toDouble()).toFloat()
        points.add(Point(x, y))
        i += 1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = true

    val drawing = Drawing().apply {
        addCurve(Curve(points, defAttribs))
    }

    val drawings = arrayListOf(drawing)
    return drawings
}

fun getCircleRing(): List<Drawing> {

    val points = ArrayList<Point>()

    var i = 0f
    while (i < 360f) {
        // Proper circle with dots
        val x = 5 * cos(Math.toRadians(i.toDouble())).toFloat()
        val y = 5 * sin(Math.toRadians(i.toDouble())).toFloat()

        // Set of lines forming a ring
        // val x = 5 * cos(i.toDouble()).toFloat()
        // val y = 5 * sin(i.toDouble()).toFloat()
        points.add(Point(x, y))
        i += 1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = true

    val drawing = Drawing().apply {
        addCurve(Curve(points, defAttribs))
    }
    val drawings = arrayListOf(drawing)

    return drawings
}

fun oneHalfCurve(): List<Drawing> {

    val points = ArrayList<Point>()

    var i = -20f
    while (i <= 20f) {
        if (i != 0f) {
            val x = i
            val y = 1f / x

            // Log.d("Curve test", "$x | $y")
            points.add(Point(x, y))
        }
        i += 1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = true

    val drawing = Drawing().apply {
        addCurve(Curve(points, defAttribs))
    }

    val drawings = arrayListOf(drawing)
    return drawings
}

fun threeEllipses(): List<Drawing> {
    val drawings = arrayListOf<Drawing>()

    drawings.add(Ellipse(0f, 0f, 4f, 5f, Ellipse.X))
    drawings.add(Ellipse(0f, 0f, 4f, 5f, -1.57f))
    drawings.add(Ellipse(0f, 0f, 4f, 5f, 1.57f))

    return drawings
}

fun circleAndCurves(): List<Drawing> {
    val drawings = arrayListOf(
        Circle(0f, 0f, 4f),
        SinCurve(-4f, 4f).apply {
            color = "#ff0000"
        },
        CosCurve(-4f, 4f).apply {
            color = "#00ff00"
        }
    )
    return drawings
}

fun sinCosTan(): List<Drawing> {
    val drawings = arrayListOf<Drawing>()

    val sinCurve = SinCurve(-7f, 7f)
    sinCurve.color = "#ff0000"

    val cosCurve = CosCurve(-7f, 7f)
    cosCurve.color = "#00ff00"

    val tanCurve = TanCurve(-7f, 7f)

    drawings.add(sinCurve)
    drawings.add(cosCurve)
    drawings.add(tanCurve)

    return drawings
}

fun protons(): List<Drawing> {
    val drawings = arrayListOf<Drawing>(
        Globe(-4f, 4f, 1f),
        Globe(-2f, 1f, 1f),
        Globe(-1f, 2f, 1f),

        Globe(-5f, -5f, 1f),
        Globe(-4f, -1f, 1f),
        Globe(-1f, -4f, 1f),

        Globe(4f, 4f, 1f),
        Globe(1f, 2f, 1f),
        Globe(2f, 1f, 1f),

        Globe(4f, -4f, 1f),
        Globe(2f, -1f, 1f),
        Globe(-2f, 1f, 1f)
    )
    return drawings
}

fun parabolaHyperbolaEllipse(): List<Drawing> {
    val drawings = arrayListOf(
        Ellipse(0f, 0f, 10f, 12f, Ellipse.X),
        Ellipse(0f, 0f, 6f, 6f, Ellipse.Y),

        Hyperbola(0f, 0f, -10f, 10f, 2f, 3f, Hyperbola.NEGATIVE_X).apply {
            this.setColor("#00ff00")
        },
        Hyperbola(0f, 0f, -10f, 10f, 2f, 3f, Hyperbola.POSITIVE_X).apply {
            this.setColor("#00ff00")
        },

        Hyperbola(0f, 0f, -10f, 10f, 3f, 2f, Hyperbola.NEGATIVE_X).apply {
            this.setColor("#0ffff0")
        },
        Hyperbola(0f, 0f, -10f, 10f, 3f, 2f, Hyperbola.POSITIVE_X).apply {
            this.setColor("#0ffff0")
        },

        Parabola(0f, 0f, -10f, 10f, 10f, 10f, Hyperbola.NEGATIVE_Y).apply {
            this.setColor("#ff0000")
        },
        Parabola(0f, 0f, -10f, 10f, 10f, 10f, Hyperbola.POSITIVE_Y).apply {
            this.setColor("#ff0000")
        }
    )
    return drawings
}