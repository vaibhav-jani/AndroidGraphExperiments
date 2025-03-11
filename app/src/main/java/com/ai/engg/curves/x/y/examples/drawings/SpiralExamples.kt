package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.models.Curve
import com.ai.engg.curves.models.CurveAttributes
import com.ai.engg.curves.models.Point
import kotlin.math.cos
import kotlin.math.sin

fun spiralExamples1(): Curve {

    val points = ArrayList<Point>()

    val x0 = 0f
    var y0 = 0f
    var radius = 20f

    var i = 0f
    while (i <= 202f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())

        points.add(Point(x, y))

        when {
            i < 40f -> y0 += 0.050f
            i < 104f -> {
                radius += 0.025f
                y0 += 0.050f
            }

            i < 158f -> y0 += 0.050f
            else -> {
                radius += 0.025f
                y0 += 0.050f
            }
        }

        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}

fun spiralExamples2(): Curve {

    val points = ArrayList<Point>()

    var x0 = 0f
    val y0 = 0f
    var radius = 20f
    var i = 0f

    while (i <= 48f) {
        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())
        points.add(Point(x, y))
        radius -= 0.075f
        x0 += 0.15f
        // y0 += 0.15f

        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}

fun spiralExamples3(): Curve {

    val points = ArrayList<Point>()

    var x0 = 0f
    val y0 = 0f
    val radius = 20f

    var i = 0f
    while (i <= 44f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())
        points.add(Point(x, y))

        // radius += 0.075f
        x0 += 0.15f
        // y0 += 0.15f
        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}


fun spiralExamples4(): Curve {

    val points = ArrayList<Point>()

    val x0 = 0f
    var y0 = 0f
    val radius = 20f

    var i = 0f
    while (i <= 44f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())
        points.add(Point(x, y))

        // radius += 0.075f
        // x0 += 0.15f
        y0 += 0.15f
        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}

fun spiralExamples5(): Curve {

    val points = ArrayList<Point>()

    var x0 = 0f
    var y0 = 0f
    var radius = 1f

    var i = 0f

    while (i <= 36f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())

        points.add(Point(x, y))
        radius += 0.075f

        x0 += 0.15f
        y0 += 0.15f

        i += 0.1f
    }

    radius = 1f

    i = 0f
    while (i <= 36f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())

        points.add(Point(x, y))
        radius += 0.075f

        x0 += 0.15f
        y0 += 0.15f

        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}

fun spiralExample6(): Curve {

    val points = ArrayList<Point>()

    var x0 = 0f
    var y0 = 0f
    var radius = 1f

    var i = 0f
    while (i <= 108f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())
        points.add(Point(x, y))
        when {
            i < 36f -> {
                radius += 0.075f
                x0 += 0.15f
                y0 += 0.15f
            }

            i < 72f -> {
                radius -= 0.075f
                // x0 -= 0.15f
                y0 += 0.15f
            }

            else -> {
                radius += 0.075f
                // x0 -= 0.15f
                y0 += 0.15f
            }
        }
        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}

fun spiralExample7(): Curve {

    val points = ArrayList<Point>()

    var x0 = 0f
    var y0 = 0f
    var radius = 1f

    var i = 0f
    while (i <= 72f) {

        val x = x0 + (radius * cos(i.toDouble()).toFloat())
        val y = y0 + (radius * sin(i.toDouble()).toFloat())
        points.add(Point(x, y))
        radius += 0.075f

        if (i < 36f) {
            x0 += 0.15f
        } else {
            x0 -= 0.15f
        }

        y0 += 0.15f
        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}

fun spiralExample8(): Curve {

    val points = arrayListOf<Point>()

    var x0 = 0f
    var y0 = 0f
    var radius = 1f

    var i = 0f
    while (i <= 252f) {
        when {
            i < 42f -> {
                points.add(Point(x0 + radius * cos(i), y0 + radius * sin(i)))
                radius += 0.115f
                x0 += 0.15f
            }
            i < 75f -> {
                points.add(Point(x0 + radius * cos(i), y0 + radius * sin(i)))
                radius -= 0.115f
                x0 += 0.15f
            }
            i < 120f -> {
                points.add(Point(x0 + radius * cos(i), y0 + radius * sin(i)))
                radius += 0.075f
                x0 += 0.15f
            }
            i < 148f -> {
                points.add(Point(x0 + radius * cos(i), y0 + radius * sin(i)))
                radius -= 0.075f
                x0 += 0.15f
            }
            i < 180f -> {
                points.add(Point(x0 + radius * cos(i), y0 + radius * sin(i)))
                radius += 0.05f
                x0 += 0.15f
            }
            else -> {
                points.add(Point(x0 + radius * cos(i), y0 + radius * sin(i)))
                radius -= 0.05f
                x0 += 0.15f
            }
        }
        i += 0.1f
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = false

    return Curve(points, defAttribs)
}