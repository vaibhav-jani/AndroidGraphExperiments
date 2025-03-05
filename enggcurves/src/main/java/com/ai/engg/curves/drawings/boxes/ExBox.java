package com.ai.engg.curves.drawings.boxes;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;

import java.util.ArrayList;

public class ExBox extends Box {

    public ExBox(float len, float wid, float dep, float start_x, float start_y) {

        super(len, wid, dep, start_x, start_y);
    }

    @Override
    protected void draw() {

        //Edges
        curves.add(getLine(bl, br));
        curves.add(getLine(br, tr));
        curves.add(getLine(tr, tl));
        curves.add(getLine(tl, bl));

        curves.add(getLine(blr, brr));
        curves.add(getLine(brr, trr));
        curves.add(getLine(trr, tlr));
        curves.add(getLine(tlr, blr));

        curves.add(getLine(bl, blr));
        curves.add(getLine(br, brr));
        curves.add(getLine(tr, trr));
        curves.add(getLine(tl, tlr));

        //Side crosses
        curves.add(getDottedLine(tl, trr));
        curves.add(getDottedLine(tlr, tr));

        curves.add(getDottedLine(bl, brr));
        curves.add(getDottedLine(blr, br));

        curves.add(getDottedLine(bl, tr));
        curves.add(getDottedLine(tl, br));

        curves.add(getDottedLine(tlr, brr));
        curves.add(getDottedLine(trr, blr));

        curves.add(getDottedLine(tr, brr));
        curves.add(getDottedLine(trr, br));

        curves.add(getDottedLine(tl, blr));
        curves.add(getDottedLine(bl, tlr));

        //Inside crosses
        curves.add(getDottedLine(br, tlr));
        curves.add(getDottedLine(bl, trr));

        curves.add(getDottedLine(tr, blr));
        curves.add(getDottedLine(tl, brr));

        curves.add(getDottedLine(brr, tl));
        curves.add(getDottedLine(blr, tr));

        curves.add(getDottedLine(trr, bl));
        curves.add(getDottedLine(tlr, br));

    }

    protected Curve getDottedLine(SurfacePoint bl, SurfacePoint br) {

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor("#09FF0000");
        defAttribs.setDrawPoints(false);

        ArrayList<SurfacePoint> blbr = new ArrayList<SurfacePoint>();
        blbr.add(bl);
        blbr.add(br);

        Curve line = new Curve(blbr, defAttribs);
        return line;
    }
}
