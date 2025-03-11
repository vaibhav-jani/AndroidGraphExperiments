package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.boxes.Box
import com.ai.engg.curves.drawings.boxes.ExBox
import com.ai.engg.curves.drawings.boxes.OpenBox
import com.ai.engg.curves.drawings.boxes.FilledBox
import com.ai.engg.curves.models.Drawing

fun emptyComplexIsometric(): List<Drawing> {
    val l = 16f
    val w = 12f
    val d = 8f

    val box = OpenBox(l * 25, w * 25, d * 25, 0f, 0f)
    val box1 = Box(l * 8, w * 8, -d * 8, box.blr.x, box.blr.y)
    val box2 = Box(l * 10, -w * 8, -d * 10, box.brr.x, box.brr.y)
    val box3 = Box(l * 4, w * 4, -d * 4, box1.bl.x, box1.bl.y)
    val box4 = Box(l * 5, -w * 4, d * 4, box.br.x, box.br.y)
    val box6 = Box(l * 8, -w * 5, -d * 6, box2.trr.x, box2.trr.y)
    val box7 = Box(l * 2, w * 7, d * 7, box.bl.x, box.bl.y)
    val box8 = Box(l * 6, w * 6, -d * 6, box1.tlr.x, box1.tlr.y)
    val box9 = Box(l * 4, -w * 4, d * 4, box8.tr.x, box8.tr.y)
    val box10 = Box(l * 3, w * 3, d * 3, box9.topCenter.x, box9.topCenter.y)
    val box11 = Box(l * 10, w * 5, d * 5, box7.tl.x, box7.tl.y)
    val box12 = Box(l * 5, -w * 4, -d * 4, box6.topCenter.x, box6.topCenter.y)
    val box13 = Box(l * 2, -w * 2, d * 2, box4.brr.x, box4.brr.y)
    val box14 = Box(l * 4, -w * 2, -d * 2, box6.br.x, box6.br.y)
    val box15 = Box(l * 6, w * 3, d * 3, box2.tl.x, box2.tl.y)
    val box16 = Box(l * 6, -w, -d, box11.trr.x, box11.trr.y)
    val box17 = Box(l * 4, w * 4, d * 4, box11.topCenter.x, box11.topCenter.y + box16.length)
    val box18 = Box(l * 4, w * 2, d * 2, box10.topCenter.x, box10.topCenter.y)
    val box19 = Box(l * 3, w * 2, -d * 2, box17.tlr.x, box17.tlr.y)
    val box20 = Box(l * 3, -w * 3, -d * 3, box12.topCenter.x, box12.topCenter.y)
    val box21 = Box(l * 2, w * 2, -d * 2, box3.tlr.x, box3.tlr.y)
    val box22 = Box(l * 4, -w * 3, -d * 3, box15.topCenter.x, box15.topCenter.y)
    val box23 = Box(l * 4, w * 4, -d * 6, box1.brr.x, box1.brr.y)
    val box24 = Box(l * 3, -w * 2, d * 2, box23.topCenter.x, box23.topCenter.y)
    val box25 = Box(l * 6, -w * 2, d * 2, box22.topCenter.x, box22.topCenter.y)
    val box26 = Box(l * 8, -w * 5, d * 5, box4.bl.x, box4.bl.y)
    val box5 = Box(l * 3, -w * 3, d * 3, box26.bl.x, box26.bl.y)

    val drawings = arrayListOf<Drawing>(
        box, box1, box2, box3, box4, box5, box6, box7, box8, box9,
        box10, box11, box12, box13, box14, box15, box16, box17, box18,
        box19, box20, box21, box22, box23, box24, box25, box26
    )
    return drawings
}

fun exComplexIsometric(): List<Drawing> {
    val l = 16f
    val w = 12f
    val d = 8f

    val box = OpenBox(l * 25, w * 25, d * 25, 0f, 0f)
    val box1 = ExBox(l * 8, w * 8, -d * 8, box.blr.x, box.blr.y)
    val box2 = ExBox(l * 10, -w * 8, -d * 10, box.brr.x, box.brr.y)
    val box3 = ExBox(l * 4, w * 4, -d * 4, box1.bl.x, box1.bl.y)
    val box4 = ExBox(l * 5, -w * 4, d * 4, box.br.x, box.br.y)
    val box6 = ExBox(l * 8, -w * 5, -d * 6, box2.trr.x, box2.trr.y)
    val box7 = ExBox(l * 2, w * 7, d * 7, box.bl.x, box.bl.y)
    val box8 = ExBox(l * 6, w * 6, -d * 6, box1.tlr.x, box1.tlr.y)
    val box9 = ExBox(l * 4, -w * 4, d * 4, box8.tr.x, box8.tr.y)
    val box10 = ExBox(l * 3, w * 3, d * 3, box9.topCenter.x, box9.topCenter.y)
    val box11 = ExBox(l * 10, w * 5, d * 5, box7.tl.x, box7.tl.y)
    val box12 = ExBox(l * 5, -w * 4, -d * 4, box6.topCenter.x, box6.topCenter.y)
    val box13 = ExBox(l * 2, -w * 2, d * 2, box4.brr.x, box4.brr.y)
    val box14 = ExBox(l * 4, -w * 2, -d * 2, box6.br.x, box6.br.y)
    val box15 = ExBox(l * 6, w * 3, d * 3, box2.tl.x, box2.tl.y)
    val box16 = ExBox(l * 6, -w, -d, box11.trr.x, box11.trr.y)
    val box17 = ExBox(l * 4, w * 4, d * 4, box11.topCenter.x, box11.topCenter.y + box16.length)
    val box18 = ExBox(l * 4, w * 2, d * 2, box10.topCenter.x, box10.topCenter.y)
    val box19 = ExBox(l * 3, w * 2, -d * 2, box17.tlr.x, box17.tlr.y)
    val box20 = ExBox(l * 3, -w * 3, -d * 3, box12.topCenter.x, box12.topCenter.y)
    val box21 = ExBox(l * 2, w * 2, -d * 2, box3.tlr.x, box3.tlr.y)
    val box22 = ExBox(l * 4, -w * 3, -d * 3, box15.topCenter.x, box15.topCenter.y)
    val box23 = ExBox(l * 4, w * 4, -d * 6, box1.brr.x, box1.brr.y)
    val box24 = ExBox(l * 3, -w * 2, d * 2, box23.topCenter.x, box23.topCenter.y)
    val box25 = ExBox(l * 6, -w * 2, d * 2, box22.topCenter.x, box22.topCenter.y)
    val box26 = ExBox(l * 8, -w * 5, d * 5, box4.bl.x, box4.bl.y)
    val box5 = ExBox(l * 3, -w * 3, d * 3, box26.bl.x, box26.bl.y)

    val drawings = arrayListOf<Drawing>(
        box, box1, box2, box3, box4, box5, box6, box7, box8, box9,
        box10, box11, box12, box13, box14, box15, box16, box17, box18,
        box19, box20, box21, box22, box23, box24, box25, box26
    )

    return drawings
}

fun complexIsometric(): List<Drawing> {

    val l = 16f
    val w = 12f
    val d = 8f

    val box = OpenBox(l * 25, w * 25, d * 25, 0f, 0f)
    val box1 = FilledBox(
        l * 8,
        w * 8,
        -d * 8,
        box.blr.x,
        box.blr.y
    )
    val box2 = FilledBox(
        l * 10,
        -w * 8,
        -d * 10,
        box.brr.x,
        box.brr.y
    )
    val box3 = FilledBox(
        l * 4,
        w * 4,
        -d * 4,
        box1.bl.x,
        box1.bl.y
    )
    val box4 = FilledBox(
        l * 5,
        -w * 4,
        d * 4,
        box.br.x,
        box.br.y
    )
    val box6 = FilledBox(
        l * 8,
        -w * 5,
        -d * 6,
        box2.trr.x,
        box2.trr.y
    )
    val box7 = FilledBox(
        l * 2,
        w * 7,
        d * 7,
        box.bl.x,
        box.bl.y
    )
    val box8 = FilledBox(
        l * 6,
        w * 6,
        -d * 6,
        box1.tlr.x,
        box1.tlr.y
    )
    val box9 = FilledBox(
        l * 4,
        -w * 4,
        d * 4,
        box8.tr.x,
        box8.tr.y
    )
    val box10 = FilledBox(
        l * 3,
        w * 3,
        d * 3,
        box9.topCenter.x,
        box9.topCenter.y
    )
    val box11 = FilledBox(
        l * 10,
        w * 5,
        d * 5,
        box7.tl.x,
        box7.tl.y
    )
    val box12 = FilledBox(
        l * 5,
        -w * 4,
        -d * 4,
        box6.topCenter.x,
        box6.topCenter.y
    )
    val box13 = FilledBox(
        l * 2,
        -w * 2,
        d * 2,
        box4.brr.x,
        box4.brr.y
    )
    val box14 = FilledBox(
        l * 4,
        -w * 2,
        -d * 2,
        box6.br.x,
        box6.br.y
    )
    val box15 = FilledBox(
        l * 6,
        w * 3,
        d * 3,
        box2.tl.x,
        box2.tl.y
    )
    val box16 = FilledBox(
        l * 6,
        -w,
        -d,
        box11.trr.x,
        box11.trr.y
    )
    val box17 = FilledBox(
        l * 4,
        w * 4,
        d * 4,
        box11.topCenter.x,
        box11.topCenter.y + box16.length
    )
    val box18 = FilledBox(
        l * 4,
        w * 2,
        d * 2,
        box10.topCenter.x,
        box10.topCenter.y
    )
    val box19 = FilledBox(
        l * 3,
        w * 2,
        -d * 2,
        box17.tlr.x,
        box17.tlr.y
    )
    val box20 = FilledBox(
        l * 3,
        -w * 3,
        -d * 3,
        box12.topCenter.x,
        box12.topCenter.y
    )
    val box21 = FilledBox(
        l * 2,
        w * 2,
        -d * 2,
        box3.tlr.x,
        box3.tlr.y
    )
    val box22 = FilledBox(
        l * 4,
        -w * 3,
        -d * 3,
        box15.topCenter.x,
        box15.topCenter.y
    )
    val box23 = FilledBox(
        l * 4,
        w * 4,
        -d * 6,
        box1.brr.x,
        box1.brr.y
    )
    val box24 = FilledBox(
        l * 3,
        -w * 2,
        d * 2,
        box23.topCenter.x,
        box23.topCenter.y
    )
    val box25 = FilledBox(
        l * 6,
        -w * 2,
        d * 2,
        box22.topCenter.x,
        box22.topCenter.y
    )
    val box26 = FilledBox(
        l * 8,
        -w * 5,
        d * 5,
        box4.bl.x,
        box4.bl.y
    )
    val box5 = FilledBox(
        l * 3,
        -w * 3,
        d * 3,
        box26.bl.x,
        box26.bl.y
    )

    val drawings = arrayListOf<Drawing>(
        box, box1, box2, box3, box4, box5, box6, box7, box8, box9,
        box10, box11, box12, box13, box14, box15, box16, box17, box18,
        box19, box20, box21, box22, box23, box24, box25, box26
    )

    return drawings
}
