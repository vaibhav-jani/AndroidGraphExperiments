package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.boxes.filled.FilledBox
import com.ai.engg.curves.models.Drawing

fun fourBoxesStacked(): List<Drawing> {
    val box4 = FilledBox(
        /* len = */ 64 * 4f,
        /* wid = */ 32 * 4f,
        /* dep = */ 24 * 4f,
        /* start_x = */ 0f,
        /* start_y = */ 0f
    )
    val box3 = FilledBox(
        /* len = */ 64 * 3f,
        /* wid = */ 32 * 3f,
        /* dep = */ 24 * 3f,
        /* start_x = */ box4.topCenter.x - 96,
        /* start_y = */ box4.topCenter.y - 36
    )
    val box2 = FilledBox(
        /* len = */ 64 * 2f,
        /* wid = */ 32 * 2f,
        /* dep = */ 24 * 2f,
        /* start_x = */ box3.topCenter.x - 64,
        /* start_y = */ box3.topCenter.y - 32
    )
    val box1 = FilledBox(
        /* len = */ 64f,
        /* wid = */ 32f,
        /* dep = */ 24f,
        /* start_x = */ box2.topCenter.x - 32,
        /* start_y = */ box2.topCenter.y - 16
    )

    return arrayListOf<Drawing>(box1, box2, box3, box4)
}