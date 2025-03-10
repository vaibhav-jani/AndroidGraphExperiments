package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.boxes.ExBox
import com.ai.engg.curves.models.Drawing

fun testExBoxes(): ArrayList<Drawing> {
    val l = 0.32f
    val w = 0.16f
    val d = 0.12f

    val exBox = ExBox(
        /* len = */ l * 24,
        /* wid = */ w * 24,
        /* dep = */ d * 24,
        /* start_x = */ 0f,
        /* start_y = */0f
    )

    val exBox11 = ExBox(
        /* len = */ l * 3,
        /* wid = */ -w * 3,
        /* dep = */ d * 3,
        /* start_x = */ exBox.br.x,
        /* start_y = */ exBox.br.y
    )
    val exBox13 = ExBox(
        /* len = */ -l * 3,
        /* wid = */ -w * 3,
        /* dep = */ d * 3,
        /* start_x = */ exBox.tr.x,
        /* start_y = */ exBox.tr.y
    )

    val exBox12 = ExBox(
        /* len = */ l * 3,
        /* wid = */ w * 3,
        /* dep = */ d * 3,
        /* start_x = */ exBox.bottomCenter.x,
        /* start_y = */ exBox.bottomCenter.y
    )

    val exBox14 = ExBox(
        /* len = */ -l * 3,
        /* wid = */ w * 3,
        /* dep = */ d * 3,
        /* start_x = */ exBox.topCenter.x,
        /* start_y = */ exBox.topCenter.y
    )

    val exBox15 = ExBox(
        /* len = */ l * 3,
        /* wid = */ w * 3,
        /* dep = */ -d * 3,
        /* start_x = */ exBox.blr.x,
        /* start_y = */ exBox.blr.y
    )

    val exBox16 = ExBox(
        /* len = */ -l * 3,
        /* wid = */ w * 3,
        /* dep = */ -d * 3,
        /* start_x = */ exBox.tlr.x,
        /* start_y = */ exBox.tlr.y
    )

    return arrayListOf(
        exBox, exBox11, exBox12, exBox13, exBox14, exBox15, exBox16
    )
}