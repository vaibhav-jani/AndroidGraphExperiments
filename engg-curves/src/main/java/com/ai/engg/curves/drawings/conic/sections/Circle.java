package com.ai.engg.curves.drawings.conic.sections;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.models.Point;

import java.util.ArrayList;

public class Circle extends Drawing {

    private final float x0;
    private final float y0;
    private final float radius;
    private String color = "#0000FF";

    public Circle(
            float x0,
            float y0,
            float radius
    ) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;

        draw();
    }

    private void draw() {
        ArrayList<Point> points = new ArrayList<Point>();

        for (float i = 0; i <= 6.3; i = i + 0.1f) {
            float x = x0 + (radius * ((float) Math.cos(i)));
            float y = y0 + (radius * ((float) Math.sin(i)));
            points.add(new Point(x, y));
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(false);
        curves.add(new Curve(points, defAttribs));
    }

    public Curve getCurve() {
        return curves.get(0);
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
