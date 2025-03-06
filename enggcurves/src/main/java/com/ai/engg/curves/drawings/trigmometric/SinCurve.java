package com.ai.engg.curves.drawings.trigmometric;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

import java.util.ArrayList;

public class SinCurve extends Drawing {

    private final float start;
    private final float end;
    private String color = "#aa0000FF";

    public SinCurve(float start, float end) {
        this.start = start;
        this.end = end;
        draw();
    }

    private void draw() {
        ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

        for (float i = start; i < end; i = i + 0.1f) {
            points.add(new SurfacePoint(i, (float) Math.sin(i)));
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(false);

        curves.add(new Curve(points, defAttribs));
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        redraw();
    }

    private void redraw() {
        curves.clear();
        draw();
    }
}
