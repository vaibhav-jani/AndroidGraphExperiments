package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.models.Curve
import com.ai.engg.curves.models.CurveAttributes
import com.ai.engg.curves.models.Point

fun simpleAssembledBox(): List<Curve> {

    val points1 = arrayListOf(
        Point(-2 * 2f, 1f),
        Point(2 * 2f, 1f),
        Point(2 * 2f, -3f),
        Point(-2 * 2f, -3f),
        Point(-2 * 2f, 1f),

        Point(-1 * 2f, 3f),
        Point(3 * 2f, 3f),
        Point(2 * 2f, 1f),
        Point(2 * 2f, -3f),
        Point(3 * 2f, -1f),
        Point(3 * 2f, 3f),
        Point(3 * 2f, -1f),
        Point(2 * 2f, -3f),
        Point(-2 * 2f, -3f),
        Point(-1 * 2f, -1f),
        Point(-1 * 2f, 3f),
        Point(-1 * 2f, -1f),
        Point(3 * 2f, -1f)
    )

    val pathAttributes1 = CurveAttributes()
    val path1 = Curve(points1, pathAttributes1)

    val points2 = arrayListOf(
        Point(3 * 2f, -1f),
        Point(-2 * 2f, 1f)
    )
    val pathAttributes2 = CurveAttributes().apply {
        pathColor = "#FF0000"
    }
    val path2 = Curve(points2, pathAttributes2)

    val points3 = arrayListOf(
        Point(-2 * 2f, -3f),
        Point(3 * 2f, 3f)
    )
    val path3 = Curve(points3, pathAttributes2)

    val points4 = arrayListOf(
        Point(-1 * 2f, 3f),
        Point(2 * 2f, -3f)
    )
    val path4 = Curve(points4, pathAttributes2)

    val points5 = arrayListOf(
        Point(-1 * 2f, -1f),
        Point(2 * 2f, 1f)
    )
    val path5 = Curve(points5, pathAttributes2)

    val paths = arrayListOf(path1, path2, path3, path4, path5)

    return paths
}

fun fourBoxesAssembled(): List<Curve> {
    val paths = arrayListOf<Curve>()
    with(paths) {
        addAll(drawCubeOnPaths(64 * 4f, -32 * 4f, -24 * 4f, 0f, 0f))
        addAll(drawCubeOnPaths(64f, 32f, 24f, 0f, 0f))
        addAll(drawCubeOnPaths(64 * 3f, 32 * 3f, -24 * 3f, 0f, 0f))
        addAll(drawCubeOnPaths(64 * 2f, -32 * 2f, 24 * 2f, 0f, 0f))
    }
    return paths
}

fun twoNestedBoxes(): List<Curve> {
    val paths = arrayListOf<Curve>()

    val l1 = 64 * 4f
    val w1 = 32 * 4f
    val d1 = -24 * 4f

    val l2 = 64f
    val w2 = 32f
    val d2 = -24f

    with(paths) {
        addAll(drawCubeOnPaths(l1, w1, d1, 0f, 0f))
        addAll(drawCubeOnPaths(l2, w2, d2, 0f, 0f))
    }

    return paths
}

private fun drawCubeOnPaths(
    len: Float,
    wid: Float,
    dep: Float,
    startX: Float,
    startY: Float
): ArrayList<Curve> {
    val paths = ArrayList<Curve>()

    val p1 = Point(startX, startY)
    val p2 = Point(wid, startY)
    val p3 = Point(wid, len)
    val p4 = Point(startX, len)

    val p5 = Point(p1.x - dep, p1.y - dep)
    val p6 = Point(p2.x - dep, p2.y - dep)
    val p7 = Point(p3.x - dep, p3.y - dep)
    val p8 = Point(p4.x - dep, p4.y - dep)

    with(paths) {
        add(getBlueLine(p1, p2))
        add(getBlueLine(p2, p3))
        add(getBlueLine(p3, p4))
        add(getBlueLine(p4, p1))

        add(getBlueLine(p5, p6))
        add(getBlueLine(p6, p7))
        add(getBlueLine(p7, p8))
        add(getBlueLine(p8, p5))

        add(getBlueLine(p1, p5))
        add(getBlueLine(p2, p6))
        add(getBlueLine(p3, p7))
        add(getBlueLine(p4, p8))
    }

    return paths
}

private fun getBlueLine(p1: Point, p2: Point): Curve {
    val defAttribs = CurveAttributes()
    val p1p2 = arrayListOf(p1, p2)
    return Curve(p1p2, defAttribs)
}
