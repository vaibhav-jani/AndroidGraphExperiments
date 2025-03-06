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
        curves.add(getSideCrossLine(tl, trr));
        curves.add(getSideCrossLine(tlr, tr));

        curves.add(getSideCrossLine(bl, brr));
        curves.add(getSideCrossLine(blr, br));

        curves.add(getSideCrossLine(bl, tr));
        curves.add(getSideCrossLine(tl, br));

        curves.add(getSideCrossLine(tlr, brr));
        curves.add(getSideCrossLine(trr, blr));

        curves.add(getSideCrossLine(tr, brr));
        curves.add(getSideCrossLine(trr, br));

        curves.add(getSideCrossLine(tl, blr));
        curves.add(getSideCrossLine(bl, tlr));

        //Inside crosses
        curves.add(getInCrossLine(br, tlr));
        curves.add(getInCrossLine(bl, trr));

        curves.add(getInCrossLine(tr, blr));
        curves.add(getInCrossLine(tl, brr));

        curves.add(getInCrossLine(brr, tl));
        curves.add(getInCrossLine(blr, tr));

        curves.add(getInCrossLine(trr, bl));
        curves.add(getInCrossLine(tlr, br));

    }

    // TODO Fix hard-coded colors
    protected Curve getInCrossLine(SurfacePoint bl, SurfacePoint br) {

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor("#FF0000");
        defAttribs.setDrawPoints(false);

        ArrayList<SurfacePoint> blbr = new ArrayList<SurfacePoint>();
        blbr.add(bl);
        blbr.add(br);

        return new Curve(blbr, defAttribs);
    }


    // TODO Fix hard-coded colors
    protected Curve getSideCrossLine(SurfacePoint bl, SurfacePoint br) {

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor("#00FF00");
        defAttribs.setDrawPoints(false);

        ArrayList<SurfacePoint> blbr = new ArrayList<SurfacePoint>();
        blbr.add(bl);
        blbr.add(br);

        return new Curve(blbr, defAttribs);
    }
}
