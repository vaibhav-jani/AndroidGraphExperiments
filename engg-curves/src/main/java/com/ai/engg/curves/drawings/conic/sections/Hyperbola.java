package com.ai.engg.curves.drawings.conic.sections;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class Hyperbola extends Drawing {

    public static int NEGATIVE_X = 0;
    public static int POSITIVE_X = 1;
    public static int NEGATIVE_Y = 2;
    public static int POSITIVE_Y = 3;

    private String color = "#00FF00";
    private final int x0;
    private final int yo;
    private final int start;
    private final int end;
    private final int a;
    private final int b;
    private final int direction;

    public Hyperbola(int x0, int yo, int start, int end, int a, int b, int direction) {
        this.x0 = x0;
        this.yo = yo;
        this.start = start;
        this.end = end;
        this.a = a;
        this.b = b;
        this.direction = direction;
        draw();
    }

    private void draw() {
        curves.add(getCurve(x0, yo, start, end, a, b, direction));
    }

    public Curve getCurve(int x0, int yo, int start, int end, int a, int b, int direction) {
        if (end < start) {
            int temp = start;
            start = end;
            end = temp;
        }

        if (b == 0) b = 1;

        ArrayList<Point> points = new ArrayList<Point>();

        for (float y = start; y <= end; y = y + 0.1f) {

            float x = (float) (((float) a / b) * (Math.sqrt((b * b) + (y * y))));

            if (direction == POSITIVE_X) {
                points.add(new Point(x0 + x, y + yo));
            } else if (direction == NEGATIVE_X) {
                points.add(new Point(-x + x0, y + yo));
            } else if (direction == POSITIVE_Y) {
                points.add(new Point(y + x0, x + yo));
            } else if (direction == NEGATIVE_Y) {
                points.add(new Point(y + x0, -x + yo));
            }
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(false);
        return new Curve(points, defAttribs);
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
