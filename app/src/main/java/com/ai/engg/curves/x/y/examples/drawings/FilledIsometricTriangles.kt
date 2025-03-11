package com.ai.engg.curves.x.y.examples.drawings

import com.ai.engg.curves.drawings.boxes.piramid.FilledPyramid
import com.ai.engg.curves.models.Drawing

fun filledPyramidDiamond1(): List<Drawing> {
    val l = 20f
    val w = 10f
    val d = 8f

    val p211 = FilledPyramid(l * 4, w * 4, d * 4, 0f, 0f, FilledPyramid.BOTTOM)
    val p212 = FilledPyramid(l * 4, w * 4, d * 4, p211.blr.x, p211.blr.y, FilledPyramid.BOTTOM)
    val p213 = FilledPyramid(l * 4, w * 4, d * 4, p212.blr.x, p212.blr.y, FilledPyramid.BOTTOM)

    val p221 = FilledPyramid(l * 4, w * 4, d * 4, p211.br.x, p211.br.y, FilledPyramid.BOTTOM)
    val p222 = FilledPyramid(l * 4, w * 4, d * 4, p221.blr.x, p221.blr.y, FilledPyramid.BOTTOM)
    val p223 = FilledPyramid(l * 4, w * 4, d * 4, p222.blr.x, p222.blr.y, FilledPyramid.BOTTOM)

    val p231 = FilledPyramid(l * 4, w * 4, d * 4, p221.br.x, p221.br.y, FilledPyramid.BOTTOM)
    val p232 = FilledPyramid(l * 4, w * 4, d * 4, p231.blr.x, p231.blr.y, FilledPyramid.BOTTOM)
    val p233 = FilledPyramid(l * 4, w * 4, d * 4, p232.blr.x, p232.blr.y, FilledPyramid.BOTTOM)

    val p111 =
        FilledPyramid(l * 4, w * 4, d * 4, p211.topCenter.x, p211.topCenter.y, FilledPyramid.BOTTOM)
    val p112 = FilledPyramid(l * 4, w * 4, d * 4, p111.blr.x, p111.blr.y, FilledPyramid.BOTTOM)

    val p121 = FilledPyramid(l * 4, w * 4, d * 4, p111.br.x, p111.br.y, FilledPyramid.BOTTOM)
    val p122 = FilledPyramid(l * 4, w * 4, d * 4, p121.blr.x, p121.blr.y, FilledPyramid.BOTTOM)

    val p000 =
        FilledPyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, FilledPyramid.BOTTOM)

    val drawings = arrayListOf(
        p211, p212, p213, p221, p222, p223, p231, p232, p233, p111, p112, p121, p122, p000
    )

    return drawings
}

fun filledPyramidDiamond2(): List<Drawing> {
    val l = 20f
    val w = 10f
    val d = 8f

    val p211 = FilledPyramid(l * 4, w * 4, d * 4, 0f, 0f, FilledPyramid.TOP)
    val p212 = FilledPyramid(l * 4, w * 4, d * 4, p211.blr.x, p211.blr.y, FilledPyramid.TOP)
    val p213 = FilledPyramid(l * 4, w * 4, d * 4, p212.blr.x, p212.blr.y, FilledPyramid.TOP)

    val p221 = FilledPyramid(l * 4, w * 4, d * 4, p211.br.x, p211.br.y, FilledPyramid.TOP)
    val p222 = FilledPyramid(l * 4, w * 4, d * 4, p221.blr.x, p221.blr.y, FilledPyramid.TOP)
    val p223 = FilledPyramid(l * 4, w * 4, d * 4, p222.blr.x, p222.blr.y, FilledPyramid.TOP)

    val p231 = FilledPyramid(l * 4, w * 4, d * 4, p221.br.x, p221.br.y, FilledPyramid.TOP)
    val p232 = FilledPyramid(l * 4, w * 4, d * 4, p231.blr.x, p231.blr.y, FilledPyramid.TOP)
    val p233 = FilledPyramid(l * 4, w * 4, d * 4, p232.blr.x, p232.blr.y, FilledPyramid.TOP)

    val p111 =
        FilledPyramid(l * 4, w * 4, d * 4, p211.topCenter.x, p211.topCenter.y, FilledPyramid.TOP)
    val p112 = FilledPyramid(l * 4, w * 4, d * 4, p111.blr.x, p111.blr.y, FilledPyramid.TOP)

    val p121 = FilledPyramid(l * 4, w * 4, d * 4, p111.br.x, p111.br.y, FilledPyramid.TOP)
    val p122 = FilledPyramid(l * 4, w * 4, d * 4, p121.blr.x, p121.blr.y, FilledPyramid.TOP)

    val p000 =
        FilledPyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, FilledPyramid.TOP)

    val drawings = arrayListOf(
        p211, p212, p213, p221, p222, p223, p231, p232, p233, p111, p112, p121, p122, p000
    )

    return drawings
}

fun filledPyramidDiamond3(): List<Drawing> {
    val l = 20f
    val w = 10f
    val d = 8f

    val p211 = FilledPyramid(l * 4, w * 4, d * 4, 0f, 0f, FilledPyramid.BOTTOM)
    val p212 = FilledPyramid(-l * 4, w * 4, d * 4, p211.tlr.x, p211.tlr.y, FilledPyramid.BOTTOM)
    val p213 = FilledPyramid(-l * 4, w * 4, d * 4, p212.tlr.x, p212.tlr.y, FilledPyramid.BOTTOM)

    val p221 = FilledPyramid(-l * 4, w * 4, d * 4, p211.tr.x, p211.tr.y, FilledPyramid.BOTTOM)
    val p222 = FilledPyramid(-l * 4, w * 4, d * 4, p221.tlr.x, p221.tlr.y, FilledPyramid.BOTTOM)
    val p223 = FilledPyramid(-l * 4, w * 4, d * 4, p222.tlr.x, p222.tlr.y, FilledPyramid.BOTTOM)

    val p231 = FilledPyramid(-l * 4, w * 4, d * 4, p221.tr.x, p221.tr.y, FilledPyramid.BOTTOM)
    val p232 = FilledPyramid(-l * 4, w * 4, d * 4, p231.tlr.x, p231.tlr.y, FilledPyramid.BOTTOM)
    val p233 = FilledPyramid(-l * 4, w * 4, d * 4, p232.tlr.x, p232.tlr.y, FilledPyramid.BOTTOM)

    val p111 =
        FilledPyramid(l * 4, w * 4, d * 4, p211.topCenter.x, p211.topCenter.y, FilledPyramid.BOTTOM)
    val p112 = FilledPyramid(-l * 4, w * 4, d * 4, p111.tlr.x, p111.tlr.y, FilledPyramid.BOTTOM)

    val p121 = FilledPyramid(-l * 4, w * 4, d * 4, p111.tr.x, p111.tr.y, FilledPyramid.BOTTOM)
    val p122 = FilledPyramid(-l * 4, w * 4, d * 4, p121.tlr.x, p121.tlr.y, FilledPyramid.BOTTOM)

    val p000 =
        FilledPyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, FilledPyramid.BOTTOM)

    val drawings = arrayListOf<Drawing>(
        p211, p212, p213,
        p221, p222, p223,
        p231, p232, p233,
        p111, p112,
        p121, p122,
        p000
    )
    return drawings
}

fun filledDiamond(): List<Drawing> {

    val l = 40f
    val w = 20f
    val d = 10f

    val p111 = FilledPyramid(l * 4, w * 4, d * 4, 0f, 0f, FilledPyramid.TOP)
    val p112 = FilledPyramid(l * 4, w * 4, d * 4, p111.blr.x, p111.blr.y, FilledPyramid.TOP)

    val p121 = FilledPyramid(l * 4, w * 4, d * 4, p111.br.x, p111.br.y, FilledPyramid.TOP)
    val p122 = FilledPyramid(l * 4, w * 4, d * 4, p121.blr.x, p121.blr.y, FilledPyramid.TOP)

    val p000 = FilledPyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, FilledPyramid.TOP)

    val dir = -l

    val p111r = FilledPyramid(dir * 4, w * 4, d * 4, 0f, 0f, FilledPyramid.BOTTOM)
    val p112r = FilledPyramid(dir * 4, w * 4, d * 4, p111r.tlr.x, p111r.tlr.y, FilledPyramid.BOTTOM)

    val p121r = FilledPyramid(dir * 4, w * 4, d * 4, p111r.tr.x, p111r.tr.y, FilledPyramid.BOTTOM)
    val p122r = FilledPyramid(dir * 4, w * 4, d * 4, p121r.tlr.x, p121r.tlr.y, FilledPyramid.BOTTOM)

    val p000r = FilledPyramid(dir * 4, w * 4, d * 4, p111r.bottomCenter.x, p111r.bottomCenter.y, FilledPyramid.BOTTOM)

    val drawings = arrayListOf<Drawing>(
        p111, p112,
        p121, p122,
        p000,
        p111r, p112r,
        p121r, p122r,
        p000r
    )

    return drawings
}
