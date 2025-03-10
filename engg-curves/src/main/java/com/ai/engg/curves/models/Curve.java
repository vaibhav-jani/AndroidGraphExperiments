package com.ai.engg.curves.models;

import java.util.ArrayList;
import java.util.List;

public class Curve {

    private CurveAttributes attributes = new CurveAttributes();

    private List<Point> points = new ArrayList<>();

    public Curve(List<Point> points, CurveAttributes curveAttributes) {

        if (curveAttributes != null) this.attributes = curveAttributes;
        if (points != null) this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public CurveAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CurveAttributes attributes) {
        this.attributes = attributes;
    }
}
