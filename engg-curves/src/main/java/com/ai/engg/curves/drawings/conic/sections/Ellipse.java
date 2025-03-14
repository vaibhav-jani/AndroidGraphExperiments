package com.ai.engg.curves.drawings.conic.sections;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.models.Point;

import java.util.ArrayList;

public class Ellipse extends Drawing {

    public static int X = 0;
    public static int Y = 1;

    private String color = "#0000FF";
    private final float x0;
    private final float y0;
    private final float a;
    private final float b;

    private float angle = -1;
    private int direction = -1;

    public Ellipse(
            float x0,
            float y0,
            float a,
            float b,
            int direction
    ) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
        this.b = b;
        this.direction = direction;
        draw();
    }

    public Ellipse(
            float x0,
            float y0,
            float a,
            float b,
            float angle
    ) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
        this.b = b;
        this.angle = angle;
        draw();
    }

    public Curve getCurve(
            float x0,
            float y0,
            float a,
            float b,
            int direction
    ) {
        ArrayList<Point> points = new ArrayList<>();

        for (float i = 0; i <= 6.3; i = i + 0.1f) {
            float x = x0 + (a * ((float) Math.cos(i)));
            float y = y0 + (b * ((float) Math.sin(i)));
            if (direction == X) {
                points.add(new Point(x, y));
            } else {
                points.add(new Point(y, x));
            }
        }
        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(false);
        return new Curve(points, defAttribs);
    }

    public Curve getAngelCurve(
            float x0,
            float y0,
            float a,
            float b,
            float angle
    ) {
        ArrayList<Point> points = new ArrayList<>();

        for (float i = 0; i <= 6.3; i = i + 0.1f) {

            float x = x0 + (a * ((float) Math.cos(i)));
            float y = y0 + (b * ((float) Math.sin(i)));

            x = x + (float) ((x * Math.cos(angle)) - (y * Math.sin(angle)));
            y = y + (float) ((y * Math.cos(angle)) + (x * Math.sin(angle)));

            points.add(new Point(x, y));
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(false);

        return new Curve(points, defAttribs);
    }

    public Curve getCurve() {
        return curves.get(0);
    }

    private void draw() {
        if (direction != -1) {
            curves.add(getCurve(x0, y0, a, b, direction));
        }

        if (angle != -1) {
            curves.add(getAngelCurve(x0, y0, a, b, angle));
        }
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
