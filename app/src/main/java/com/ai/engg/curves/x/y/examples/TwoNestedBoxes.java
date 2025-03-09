package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.display.window.MathCurveView;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class TwoNestedBoxes extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l1 = 64 * 4;
        int w1 = 32 * 4;
        int d1 = -24 * 4;

        int l2 = 64;
        int w2 = 32;
        int d2 = -24;

        ArrayList<Curve> curves = new ArrayList<Curve>();
        drawCubeOncurves(curves, l1, w1, d1, 0, 0);
        drawCubeOncurves(curves, l2, w2, d2, 0, 0);
        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();

        Drawing drawing = new Drawing();
        drawing.setCurves(curves);

        setContentView(new MathCurveView(this, drawing, surfaceAttributes));
    }

    private void drawCubeOncurves(ArrayList<Curve> curves, int len, int wid, int dep, int start_x, int start_y) {

        Point p1 = new Point(start_x, start_y);
        Point p2 = new Point(start_x + wid, start_y);
        Point p3 = new Point(start_x + wid, len + start_y);
        Point p4 = new Point(start_x, len + start_y);

        Point p5 = new Point(p1.x - dep, p1.y - dep);
        Point p6 = new Point(p2.x - dep, p2.y - dep);
        Point p7 = new Point(p3.x - dep, p3.y - dep);
        Point p8 = new Point(p4.x - dep, p4.y - dep);


        curves.add(getBlueLine(p1, p2));
        curves.add(getBlueLine(p2, p3));
        curves.add(getBlueLine(p3, p4));
        curves.add(getBlueLine(p4, p1));

        curves.add(getBlueLine(p5, p6));
        curves.add(getBlueLine(p6, p7));
        curves.add(getBlueLine(p7, p8));
        curves.add(getBlueLine(p8, p5));

        curves.add(getBlueLine(p1, p5));
        curves.add(getBlueLine(p2, p6));
        curves.add(getBlueLine(p3, p7));
        curves.add(getBlueLine(p4, p8));

    }

    Curve getBlueLine(Point p1, Point p2) {

        CurveAttributes defAttribs = new CurveAttributes();

        ArrayList<Point> p1p2 = new ArrayList<Point>();
        p1p2.add(p1);
        p1p2.add(p2);

        Curve line = new Curve(p1p2, defAttribs);
        return line;
    }

    Curve getRedLine(Point p1, Point p2) {

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor("#FF0000");

        ArrayList<Point> p1p2 = new ArrayList<Point>();
        p1p2.add(p1);
        p1p2.add(p2);

        Curve line = new Curve(p1p2, defAttribs);
        return line;
    }
}