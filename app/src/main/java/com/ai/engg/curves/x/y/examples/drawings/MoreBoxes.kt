package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.boxes.FilledBox
import com.ai.engg.curves.models.Drawing

fun eightBoxes(): ArrayList<Drawing> {

    val l1 = 64 * 4f
    val w1 = 32 * 4f
    val d1 = 24 * 4f

    val l2 = 64 * 2f
    val w2 = 32 * 2f
    val d2 = 24 * 2f

    val box = FilledBox(l1, w1, d1, 0f, 0f)
    val box2 = FilledBox(l2, w2, d2, box.br.x, box.br.y)
    val box3 = FilledBox(l2, w2, d2, -100f, -100f)
    val box4 = FilledBox(l2, w2, d2, -100f, 100f)
    val box5 = FilledBox(-l2, -w2, d2, 100f, -100f)
    val box6 = FilledBox(l1, w1, -d1, box2.br.x, box2.br.y)
    val box7 = FilledBox(l1, -w1, d1, box4.blr.x, box4.blr.y)
    val box8 = FilledBox(-l1, -w1, -d1, box3.bl.x, box3.bl.y)

    return arrayListOf(box, box2, box3, box4, box5, box6, box7, box8)
}

fun eightColoredBoxes(): ArrayList<Drawing> {

    val l1 = 64 * 4f
    val w1 = 32 * 4f
    val d1 = 24 * 4f

    val l2 = 64 * 2f
    val w2 = 32 * 2f
    val d2 = 24 * 2f

    val box = FilledBox(l1, w1, d1, 0f, 0f)
    val box2 = FilledBox(l2, w2, d2, box.br.x, box.br.y)
    val box3 = FilledBox(l2, w2, d2, -100f, -100f)
    val box4 = FilledBox(l2, w2, d2, -100f, 100f)
    val box5 = FilledBox(-l2, -w2, d2, 100f, -100f)
    val box6 = FilledBox(l1, w1, -d1, box2.br.x, box2.br.y)
    val box7 = FilledBox(l1, -w1, d1, box4.blr.x, box4.blr.y)
    val box8 = FilledBox(-l1, -w1, -d1, box3.bl.x, box3.bl.y)

    // Add colors
    box8.sideColor = "#ffff00"
    box8.topColor = "#ff00ff"
    box8.frontColor = "#00ffff"
    box8.color = "#000000"

    return arrayListOf(box, box2, box3, box4, box5, box6, box7, box8)
}