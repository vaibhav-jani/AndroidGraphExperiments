package com.ai.engg.curves.drawings.trigmometric;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class CosCurve extends Drawing {

    private final float start;
    private final float end;
    private String color = "#0000FF";

    public CosCurve(float start, float end) {
        this.start = start;
        this.end = end;
        draw();
    }

    private void draw() {
        ArrayList<Point> points = new ArrayList<Point>();

        for (float i = start; i < end; i = i + 0.1f) {
            points.add(new Point(i, (float) Math.cos(i)));
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
