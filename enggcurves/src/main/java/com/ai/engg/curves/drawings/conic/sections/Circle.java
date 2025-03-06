package com.ai.engg.curves.drawings.conic.sections;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

import java.util.ArrayList;

public class Circle extends Drawing {

    private final int x0;
    private final int y0;
    private final int radius;
    private String color = "#0000FF";

    public Circle(int x0, int y0, int radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;

        draw();
    }

    private void draw() {
        ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

        for (float i = 0; i <= 6.3; i = i + 0.1f) {
            points.add(new SurfacePoint(x0 + (radius * ((float) Math.cos(i))), y0 + (radius * ((float) Math.sin(i)))));
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
