package com.ai.engg.curves.drawings.trigmometric;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

import java.util.ArrayList;

public class TanCurve extends Drawing {

    private String color = "#0000FF";

    public TanCurve(float start, float end) {

        ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

        for (float i = start; i < end; i = i + 0.1f) {
            points.add(new SurfacePoint(i, (float) Math.tan(i)));
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(false);

        curves.add(new Curve(points, defAttribs));
    }
}
