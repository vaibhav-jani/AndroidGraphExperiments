package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.conic.sections.Circle
import com.ai.engg.curves.drawings.conic.sections.Parabola
import com.ai.engg.curves.models.Curve
import com.ai.engg.curves.models.CurveAttributes
import com.ai.engg.curves.models.Point

fun getLines(): List<Curve> {

    val points1 = ArrayList<Point>()
    points1.add(Point(-4f, 0f))
    points1.add(Point(3f, 0f))

    val pathAttributes1 = CurveAttributes()
    val path1 = Curve(points1, pathAttributes1)

    val paths = ArrayList<Curve>()
    paths.add(path1)

    val points2 = ArrayList<Point>()
    points2.add(Point(2f, 2f))
    points2.add(Point(-2f, -2f))

    val pathAttributes2 = CurveAttributes()
    pathAttributes2.pathColor = "#00ff00"
    val path2 = Curve(points2, pathAttributes2)
    paths.add(path2)

    val points3 = ArrayList<Point>()
    points3.add(Point(0f, 1.5f))
    points3.add(Point(0f, -1.5f))

    val pathAttributes3 = CurveAttributes()
    pathAttributes3.pathColor = "#ff0000"
    val path3 = Curve(points3, pathAttributes3)
    paths.add(path3)

    val points4 = ArrayList<Point>()
    points4.add(Point(-2f, 1f))
    points4.add(Point(2f, -1f))

    val pathAttributes4 = CurveAttributes()
    pathAttributes4.pathColor = "#ffff00"
    val path4 = Curve(points4, pathAttributes4)
    paths.add(path4)

    return paths
}

fun getLinesAndCircles(): List<Curve> {

    val paths = mutableListOf<Curve>()
    paths.addAll(getLines())

    val circle1 = Circle(0f, 0f, 1f)
    val circleCurve1 = circle1.curve
    circleCurve1.attributes.pathColor = "#ff0fff"
    paths.add(circleCurve1)

    val circle2 = Circle(2f, 2f, 0.5f)
    val circleCurve2 = circle2.curve
    circleCurve2.attributes.pathColor = "#00ffff"
    paths.add(circleCurve2)

    return paths
}

fun getLinesAndCirclesAndCurves(): List<Curve> {

    val paths = mutableListOf<Curve>()
    paths.addAll(getLinesAndCircles())

    // Adding Parabolas
    val parabola1 = Parabola(-1f, 1f, -2f, 2f, 1.5f, 1f, Parabola.NEGATIVE_X)
    parabola1.setColor("#FF1493") // Deep Pink for a vibrant touch
    paths.add(parabola1.curve)

    val parabola2 = Parabola(1f, -1f, -2f, 2f, -1.5f, 1f, Parabola.NEGATIVE_X)
    parabola2.setColor("#00CED1") // Dark Turquoise for contrast
    paths.add(parabola2.curve)

    return paths
}