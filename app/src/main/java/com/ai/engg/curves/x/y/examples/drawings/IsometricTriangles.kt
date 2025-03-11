import com.ai.engg.curves.drawings.boxes.piramid.Pyramid
import com.ai.engg.curves.models.Drawing

fun simpleDiamond(): List<Drawing> {

    val l = 40f
    val w = 20f
    val d = 10f

    val dir = -l

    val p111 = Pyramid(l * 4, w * 4, d * 4, 0f, 0f, Pyramid.TOP)
    val p112 = Pyramid(l * 4, w * 4, d * 4, p111.blr.x, p111.blr.y, Pyramid.TOP)

    val p121 = Pyramid(l * 4, w * 4, d * 4, p111.br.x, p111.br.y, Pyramid.TOP)
    val p122 = Pyramid(l * 4, w * 4, d * 4, p121.blr.x, p121.blr.y, Pyramid.TOP)

    val p000 = Pyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, Pyramid.TOP)

    val p111r = Pyramid(dir * 4, w * 4, d * 4, 0f, 0f, Pyramid.BOTTOM)
    val p112r = Pyramid(dir * 4, w * 4, d * 4, p111r.tlr.x, p111r.tlr.y, Pyramid.BOTTOM)

    val p121r = Pyramid(dir * 4, w * 4, d * 4, p111r.tr.x, p111r.tr.y, Pyramid.BOTTOM)
    val p122r = Pyramid(dir * 4, w * 4, d * 4, p121r.tlr.x, p121r.tlr.y, Pyramid.BOTTOM)

    val p000r = Pyramid(dir * 4, w * 4, d * 4, p111r.bottomCenter.x, p111r.bottomCenter.y, Pyramid.BOTTOM)

    val drawings = mutableListOf<Drawing>().apply {
        addAll(listOf(p111, p112, p121, p122, p000, p111r, p112r, p121r, p122r, p000r))
    }

    return drawings
}

fun complexDiamond(): List<Drawing> {

    val l = 64f
    val w = 32f
    val d = 24f

    val p311 = Pyramid(l * 4, w * 4, d * 4, 0f, 0f, Pyramid.TOP)
    val p312 = Pyramid(l * 4, w * 4, d * 4, p311.blr.x, p311.blr.y, Pyramid.TOP)
    val p313 = Pyramid(l * 4, w * 4, d * 4, p312.blr.x, p312.blr.y, Pyramid.TOP)
    val p314 = Pyramid(l * 4, w * 4, d * 4, p313.blr.x, p313.blr.y, Pyramid.TOP)

    val p321 = Pyramid(l * 4, w * 4, d * 4, p311.br.x, p311.br.y, Pyramid.TOP)
    val p322 = Pyramid(l * 4, w * 4, d * 4, p321.blr.x, p321.blr.y, Pyramid.TOP)
    val p323 = Pyramid(l * 4, w * 4, d * 4, p322.blr.x, p322.blr.y, Pyramid.TOP)
    val p324 = Pyramid(l * 4, w * 4, d * 4, p323.blr.x, p323.blr.y, Pyramid.TOP)

    val p331 = Pyramid(l * 4, w * 4, d * 4, p321.br.x, p321.br.y, Pyramid.TOP)
    val p332 = Pyramid(l * 4, w * 4, d * 4, p331.blr.x, p331.blr.y, Pyramid.TOP)
    val p333 = Pyramid(l * 4, w * 4, d * 4, p332.blr.x, p332.blr.y, Pyramid.TOP)
    val p334 = Pyramid(l * 4, w * 4, d * 4, p333.blr.x, p333.blr.y, Pyramid.TOP)

    val p341 = Pyramid(l * 4, w * 4, d * 4, p331.br.x, p331.br.y, Pyramid.TOP)
    val p342 = Pyramid(l * 4, w * 4, d * 4, p341.blr.x, p341.blr.y, Pyramid.TOP)
    val p343 = Pyramid(l * 4, w * 4, d * 4, p342.blr.x, p342.blr.y, Pyramid.TOP)
    val p344 = Pyramid(l * 4, w * 4, d * 4, p343.blr.x, p343.blr.y, Pyramid.TOP)

    val p211 = Pyramid(l * 4, w * 4, d * 4, p311.topCenter.x, p311.topCenter.y, Pyramid.TOP)
    val p212 = Pyramid(l * 4, w * 4, d * 4, p211.blr.x, p211.blr.y, Pyramid.TOP)
    val p213 = Pyramid(l * 4, w * 4, d * 4, p212.blr.x, p212.blr.y, Pyramid.TOP)

    val p221 = Pyramid(l * 4, w * 4, d * 4, p211.br.x, p211.br.y, Pyramid.TOP)
    val p222 = Pyramid(l * 4, w * 4, d * 4, p221.blr.x, p221.blr.y, Pyramid.TOP)
    val p223 = Pyramid(l * 4, w * 4, d * 4, p222.blr.x, p222.blr.y, Pyramid.TOP)

    val p231 = Pyramid(l * 4, w * 4, d * 4, p221.br.x, p221.br.y, Pyramid.TOP)
    val p232 = Pyramid(l * 4, w * 4, d * 4, p231.blr.x, p231.blr.y, Pyramid.TOP)
    val p233 = Pyramid(l * 4, w * 4, d * 4, p232.blr.x, p232.blr.y, Pyramid.TOP)

    val p111 = Pyramid(l * 4, w * 4, d * 4, p211.topCenter.x, p211.topCenter.y, Pyramid.TOP)
    val p112 = Pyramid(l * 4, w * 4, d * 4, p111.blr.x, p111.blr.y, Pyramid.TOP)

    val p121 = Pyramid(l * 4, w * 4, d * 4, p111.br.x, p111.br.y, Pyramid.TOP)
    val p122 = Pyramid(l * 4, w * 4, d * 4, p121.blr.x, p121.blr.y, Pyramid.TOP)

    val p000 = Pyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, Pyramid.TOP)

    val dir = -l

    val p311r = Pyramid(dir * 4, w * 4, d * 4, 0f, 0f, Pyramid.BOTTOM)
    val p312r = Pyramid(dir * 4, w * 4, d * 4, p311r.tlr.x, p311r.tlr.y, Pyramid.BOTTOM)
    val p313r = Pyramid(dir * 4, w * 4, d * 4, p312r.tlr.x, p312r.tlr.y, Pyramid.BOTTOM)
    val p314r = Pyramid(dir * 4, w * 4, d * 4, p313r.tlr.x, p313r.tlr.y, Pyramid.BOTTOM)

    val p321r = Pyramid(dir * 4, w * 4, d * 4, p311r.tr.x, p311r.tr.y, Pyramid.BOTTOM)
    val p322r = Pyramid(dir * 4, w * 4, d * 4, p321r.tlr.x, p321r.tlr.y, Pyramid.BOTTOM)
    val p323r = Pyramid(dir * 4, w * 4, d * 4, p322r.tlr.x, p322r.tlr.y, Pyramid.BOTTOM)
    val p324r = Pyramid(dir * 4, w * 4, d * 4, p323r.tlr.x, p323r.tlr.y, Pyramid.BOTTOM)

    val p331r = Pyramid(dir * 4, w * 4, d * 4, p321r.tr.x, p321r.tr.y, Pyramid.BOTTOM)
    val p332r = Pyramid(dir * 4, w * 4, d * 4, p331r.tlr.x, p331r.tlr.y, Pyramid.BOTTOM)
    val p333r = Pyramid(dir * 4, w * 4, d * 4, p332r.tlr.x, p332r.tlr.y, Pyramid.BOTTOM)
    val p334r = Pyramid(dir * 4, w * 4, d * 4, p333r.tlr.x, p333r.tlr.y, Pyramid.BOTTOM)

    val p341r = Pyramid(dir * 4, w * 4, d * 4, p331r.tr.x, p331r.tr.y, Pyramid.BOTTOM)
    val p342r = Pyramid(dir * 4, w * 4, d * 4, p341r.tlr.x, p341r.tlr.y, Pyramid.BOTTOM)
    val p343r = Pyramid(dir * 4, w * 4, d * 4, p342r.tlr.x, p342r.tlr.y, Pyramid.BOTTOM)
    val p344r = Pyramid(dir * 4, w * 4, d * 4, p343r.tlr.x, p343r.tlr.y, Pyramid.BOTTOM)

    val p211r = Pyramid(dir * 4, w * 4, d * 4, p311r.bottomCenter.x, p311r.bottomCenter.y, Pyramid.BOTTOM)
    val p212r = Pyramid(dir * 4, w * 4, d * 4, p211r.tlr.x, p211r.tlr.y, Pyramid.BOTTOM)
    val p213r = Pyramid(dir * 4, w * 4, d * 4, p212r.tlr.x, p212r.tlr.y, Pyramid.BOTTOM)

    val p221r = Pyramid(dir * 4, w * 4, d * 4, p211r.tr.x, p211r.tr.y, Pyramid.BOTTOM)
    val p222r = Pyramid(dir * 4, w * 4, d * 4, p221r.tlr.x, p221r.tlr.y, Pyramid.BOTTOM)
    val p223r = Pyramid(dir * 4, w * 4, d * 4, p222r.tlr.x, p222r.tlr.y, Pyramid.BOTTOM)

    val p231r = Pyramid(dir * 4, w * 4, d * 4, p221r.tr.x, p221r.tr.y, Pyramid.BOTTOM)
    val p232r = Pyramid(dir * 4, w * 4, d * 4, p231r.tlr.x, p231r.tlr.y, Pyramid.BOTTOM)
    val p233r = Pyramid(dir * 4, w * 4, d * 4, p232r.tlr.x, p232r.tlr.y, Pyramid.BOTTOM)

    val p111r = Pyramid(dir * 4, w * 4, d * 4, p211r.bottomCenter.x, p211r.bottomCenter.y, Pyramid.BOTTOM)
    val p112r = Pyramid(dir * 4, w * 4, d * 4, p111r.tlr.x, p111r.tlr.y, Pyramid.BOTTOM)

    val p121r = Pyramid(dir * 4, w * 4, d * 4, p111r.tr.x, p111r.tr.y, Pyramid.BOTTOM)
    val p122r = Pyramid(dir * 4, w * 4, d * 4, p121r.tlr.x, p121r.tlr.y, Pyramid.BOTTOM)

    val p000r = Pyramid(dir * 4, w * 4, d * 4, p111r.bottomCenter.x, p111r.bottomCenter.y, Pyramid.BOTTOM)

    val drawings = arrayListOf(
        p311, p312, p313, p314,
        p321, p322, p323, p324,
        p331, p332, p333, p334,
        p341, p342, p343, p344,

        p211, p212, p213,
        p221, p222, p223,
        p231, p232, p233,
        p111, p112,
        p121, p122,
        p000,

        p311r, p312r, p313r, p314r,
        p321r, p322r, p323r, p324r,
        p331r, p332r, p333r, p334r,
        p341r, p342r, p343r, p344r,

        p211r, p212r, p213r,
        p221r, p222r, p223r,
        p231r, p232r, p233r,
        p111r, p112r,
        p121r, p122r,
        p000r
    )

    return drawings
}

fun simplePyramidDiamond(): List<Drawing> {

    val l = 4f
    val w = 2f
    val d = 1f

    val p211 = Pyramid(l * 4, w * 4, d * 4, 0f, 0f, Pyramid.TOP)
    val p212 = Pyramid(l * 4, w * 4, d * 4, p211.blr.x, p211.blr.y, Pyramid.TOP)
    val p213 = Pyramid(l * 4, w * 4, d * 4, p212.blr.x, p212.blr.y, Pyramid.TOP)

    val p221 = Pyramid(l * 4, w * 4, d * 4, p211.br.x, p211.br.y, Pyramid.TOP)
    val p222 = Pyramid(l * 4, w * 4, d * 4, p221.blr.x, p221.blr.y, Pyramid.TOP)
    val p223 = Pyramid(l * 4, w * 4, d * 4, p222.blr.x, p222.blr.y, Pyramid.TOP)

    val p231 = Pyramid(l * 4, w * 4, d * 4, p221.br.x, p221.br.y, Pyramid.TOP)
    val p232 = Pyramid(l * 4, w * 4, d * 4, p231.blr.x, p231.blr.y, Pyramid.TOP)
    val p233 = Pyramid(l * 4, w * 4, d * 4, p232.blr.x, p232.blr.y, Pyramid.TOP)

    val p111 = Pyramid(l * 4, w * 4, d * 4, p211.topCenter.x, p211.topCenter.y, Pyramid.TOP)
    val p112 = Pyramid(l * 4, w * 4, d * 4, p111.blr.x, p111.blr.y, Pyramid.TOP)

    val p121 = Pyramid(l * 4, w * 4, d * 4, p111.br.x, p111.br.y, Pyramid.TOP)
    val p122 = Pyramid(l * 4, w * 4, d * 4, p121.blr.x, p121.blr.y, Pyramid.TOP)

    val p000 = Pyramid(l * 4, w * 4, d * 4, p111.topCenter.x, p111.topCenter.y, Pyramid.TOP)

    val drawings = arrayListOf(
        p211, p212, p213,
        p221, p222, p223,
        p231, p232, p233,
        p111, p112,
        p121, p122,
        p000
    )

    return drawings
}