package com.ai.engg.curves.drawings.boxes;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Point;

import java.util.ArrayList;

public class FilledBox extends Box {

    // TODO Fix hard-coded colors
    protected String frontColor = "#450000FF";
    protected String sideColor = "#300000FF";
    protected String topColor = "#150000FF";

    public FilledBox(
            float len,
            float wid,
            float dep,
            float start_x,
            float start_y
    ) {
        super(len, wid, dep, start_x, start_y);
        fillFront();
        fillTop();
        fillSide();
    }

    @Override
    protected void draw() {

        super.draw();

        /*curves.add(getLine(bl, br));
        curves.add(getLine(br, tr));
        curves.add(getLine(tr, tl));
        curves.add(getLine(tl, bl));

        curves.add(getLine(brr, trr));
        curves.add(getLine(trr, tlr));

        curves.add(getLine(br, brr));
        curves.add(getLine(tr, trr));
        curves.add(getLine(tl, tlr));*/
    }

    protected void fillSide() {

        float start = br.x + 2;
        float end = brr.x;
        float count = Math.abs((start - end) / 2);
        for (float i = 0; i <= count; i++) {
            Point p1 = new Point(tr.x + (2 * i), tr.y + (2 * i));
            Point p2 = new Point(br.x + (2 * i), br.y + (2 * i));
            curves.add(getColorLine(p1, p2, sideColor));
        }
    }

    protected void fillTop() {

        float start = tl.x + 2;
        float end = tr.x;
        float count = Math.abs((start - end) / 2);
        for (float i = 0; i <= count; i++) {
            Point p1 = new Point(tl.x + (2 * i), tl.y);
            Point p2 = new Point(tlr.x + (2 * i), tlr.y);
            curves.add(getColorLine(p1, p2, topColor));
        }
    }

    protected void fillFront() {

        float start = bl.x + 2;
        float end = br.x;
        float count = Math.abs((start - end) / 2);

        for (float i = 0; i <= count; i++) {
            Point p1 = new Point(tl.x + (2 * i), tl.y);
            Point p2 = new Point(bl.x + (2 * i), bl.y);
            curves.add(getColorLine(p1, p2, frontColor));
        }
    }

    protected Curve getColorLine(Point bl, Point br, String clr) {

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(clr);
        defAttribs.setDrawPoints(false);

        ArrayList<Point> blbr = new ArrayList<Point>();
        blbr.add(bl);
        blbr.add(br);

        Curve line = new Curve(blbr, defAttribs);
        return line;
    }

    public String getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(String frontColor) {
        this.frontColor = frontColor;
        // TODO fix bad hack
        redraw();
    }

    public String getSideColor() {
        return sideColor;
    }

    public void setSideColor(String sideColor) {
        this.sideColor = sideColor;
        // TODO fix bad hack
        redraw();
    }

    public String getTopColor() {
        return topColor;
    }

    // Call this first before other colors
    public void setColor(String color) {
        this.color = color;
        // TODO Bad hack,
        redraw();
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
        // TODO fix bad hack
        redraw();
    }

    private void redraw() {
        // TODO fix bad hack
        curves.clear();
        draw();
        fillFront();
        fillTop();
        fillSide();
    }
}
