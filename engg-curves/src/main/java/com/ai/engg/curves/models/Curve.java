package com.ai.engg.curves.models;

import java.util.ArrayList;

public class Curve {

    private CurveAttributes attributes = new CurveAttributes();

    private ArrayList<Point> points = new ArrayList<Point>();

    public Curve(ArrayList<Point> points, CurveAttributes curveAttributes) {

        if (curveAttributes != null) this.attributes = curveAttributes;
        if (points != null) this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public CurveAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CurveAttributes attributes) {
        this.attributes = attributes;
    }
}
