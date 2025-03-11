package com.ai.engg.curves.x.y.examples.drawings

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