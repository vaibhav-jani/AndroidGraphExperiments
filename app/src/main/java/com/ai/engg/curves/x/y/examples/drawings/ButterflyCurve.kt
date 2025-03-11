package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.models.Curve
import com.ai.engg.curves.models.CurveAttributes
import com.ai.engg.curves.models.Point
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

fun butterflyCurve(): Curve {
    val points1 = ArrayList<Point>()
    // val points2 = ArrayList<SurfacePoint>()

    var i = 0.0
    while (i <= 200.8) {

        val sinI = sin(i)
        val cosI = cos(i)

        val bcF = (Math.E.pow(cosI)) - (2 * cos(4 * i) - sin(i / 12).pow(5))

        val x = sinI * bcF
        val y = cosI * bcF

        points1.add(Point(x.toFloat(), y.toFloat()))

        // points2.add(SurfacePoint(-y, x))

        i += 0.1
    }

    val defAttribs = CurveAttributes()
    defAttribs.isDrawPoints = true

    return Curve(points1, defAttribs)
}