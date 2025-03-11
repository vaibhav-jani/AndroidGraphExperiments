package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.boxes.Box
import com.ai.engg.curves.drawings.boxes.OpenBox
import com.ai.engg.curves.drawings.boxes.filled.ClosedBox
import com.ai.engg.curves.models.Drawing

fun simpleIsoMetricExample1(): List<Drawing> {

    val l1 = 100
    val w1 = 100
    val d1 = 60

    val baseBox = ClosedBox(l1 * 0.01f, w1.toFloat(), d1.toFloat(), 0f, 0f)

    val box1 = ClosedBox(l1 * 0.7f, w1 * 0.10f, -d1 * 0.40f, baseBox.blr.x, baseBox.blr.y)
    val box2 = ClosedBox(l1 * 0.7f, w1 * 0.40f, -d1 * 0.10f, box1.brr.x, box1.brr.y)
    val box3 = ClosedBox(l1 * 0.35f, -w1 * 0.20f, d1 * 0.15f, box1.tr.x, box1.tr.y)
    val box4 = ClosedBox(l1 * 0.15f, w1 * 0.10f, -d1 * 0.10f, box3.tlr.x, box3.tlr.y)

    val box5 = ClosedBox(l1 * 0.25f, w1 * 0.20f, -d1 * 0.20f, box2.bl.x, box2.bl.y)
    val box6 = ClosedBox(l1 * 0.50f, w1 * 0.10f, -d1 * 0.10f, box5.brr.x, box5.brr.y)
    val box7 = ClosedBox(l1 * 0.15f, -w1 * 0.15f, -d1 * 0.20f, box6.trr.x, box6.trr.y)
    val box8 = ClosedBox(l1 * 0.50f, w1 * 0.10f, d1 * 0.10f, box7.tl.x, box7.tl.y)

    val box9 = ClosedBox(l1 * 0.45f, w1 * 0.30f, d1 * 0.30f, baseBox.tl.x + 15, baseBox.tl.y)
    val box10 = ClosedBox(l1 * 0.65f, w1 * 0.05f, d1 * 0.05f, box9.tl.x, box9.tl.y)

    val box11 = ClosedBox(l1 * 0.01f, -w1 * 0.25f, d1 * 0.25f, box10.tr.x, box10.tr.y)
    val box12 = ClosedBox(l1 * 0.65f, w1 * 0.05f, -d1 * 0.05f, box11.tlr.x, box11.tlr.y)
    val box13 = ClosedBox(l1 * 0.01f, w1 * 0.25f, d1 * 0.25f, box8.tl.x, box8.tl.y)

    return arrayListOf(
        baseBox, box1, box2, box3,
        box4, box5, box6, box7,
        box8, box9, box10, box11,
        box12, box13
    )
}

fun simpleIsoMetricExample2(): List<Drawing> {

    val l = 0.32f
    val w = 0.16f
    val d = 0.12f

    val box = OpenBox(l * 25, w * 25, d * 25, 0f, 0f)

    val box1 = Box(l * 8, w * 8, -d * 8, box.blr.x, box.blr.y)
    val box2 = Box(l * 10, -w * 8, -d * 8, box.brr.x, box.brr.y)
    val box3 = Box(l * 4, w * 3, -d * 4, box1.bl.x, box1.bl.y)
    val box4 = Box(l * 5, -w * 4, d * 4, box.br.x, box.br.y)
    val box5 = Box(l * 3, w * 3, d * 3, box.width / 2f, 0f)
    val box6 = Box(l * 5, -w * 4, -d * 4, box2.trr.x, box2.trr.y)
    val box7 = Box(l * 3, w * 3, d * 3, box1.tl.x, box1.tl.y)
    val box8 = Box(l * 6, w * 5, d * 6, box1.topCenter.x, box1.topCenter.y)
    val box9 = Box(l * 4, w * 3, d * 3, box8.topCenter.x, box8.topCenter.y)
    val box10 = Box(l * 3, w * 2, d * 2, box9.topCenter.x, box9.topCenter.y)

    val drawings = arrayListOf(
        box, box1, box2, box3,
        box4, box5, box6, box7,
        box8, box9, box10
    )

    return drawings
}

fun simpleIsoMetricColorExample(): List<Drawing> {
    val l = 0.32f
    val w = 0.16f
    val d = 0.12f

    val box = OpenBox(l * 25, w * 25, d * 25, 0f, 0f)

    val box1 = Box(l * 8, w * 8, -d * 8, box.blr.x, box.blr.y)
    val box2 = Box(l * 10, -w * 8, -d * 8, box.brr.x, box.brr.y)
    val box3 = Box(l * 4, w * 3, -d * 4, box1.bl.x, box1.bl.y)
    val box4 = Box(l * 5, -w * 4, d * 4, box.br.x, box.br.y)
    val box5 = Box(l * 3, w * 3, d * 3, box.width / 2f, 0f)
    val box6 = Box(l * 5, -w * 4, -d * 4, box2.trr.x, box2.trr.y)
    val box7 = Box(l * 3, w * 3, d * 3, box1.tl.x, box1.tl.y)
    val box8 = Box(l * 6, w * 5, d * 6, box1.topCenter.x, box1.topCenter.y)
    val box9 = Box(l * 4, w * 3, d * 3, box8.topCenter.x, box8.topCenter.y)
    val box10 = Box(l * 3, w * 2, d * 2, box9.topCenter.x, box9.topCenter.y)

    box1.setColor("#ff0000")

    val drawings = arrayListOf<Drawing>(
        box, box1, box2, box3, box4, box5, box6, box7, box8, box9, box10
    )

    return drawings
}
