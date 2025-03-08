package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class FourBoxes extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


        ArrayList<Curve> paths = new ArrayList<Curve>();
        //drawCubeOnPaths(paths, 64*3, 32*3, 24*3, 0, 0);
        drawCubeOnPaths(paths, 64 * 4, -32 * 4, -24 * 4, 0, 0);
        //drawCubeOnPaths(paths, 64*3, -32*3, 24*3, 0, 0);
        //drawCubeOnPaths(paths, 64*3, 32*3, -24*3, 0, 0);
        //drawCubeOnPaths(paths, 512, 256, 192, 0, 0);
        ///drawCubeOnPaths(paths, 256, 128, 96, 0, 0);
        //drawCubeOnPaths(paths, 224, 112, 72, 0, 0);
        //drawCubeOnPaths(paths, 192, 96, 60, 0, 0);
        //drawCubeOnPaths(paths, 128, 64, 48, 0, 0);
        //drawCubeOnPaths(paths, 96, 48, 36, 0, 0);
        drawCubeOnPaths(paths, 64, 32, 24, 0, 0);
        //drawCubeOnPaths(paths, 64*2, -32*2, -24*2, 0, 0);
        drawCubeOnPaths(paths, 64 * 3, 32 * 3, -24 * 3, 0, 0);
        drawCubeOnPaths(paths, 64 * 2, -32 * 2, 24 * 2, 0, 0);
        //drawCubeOnPaths(paths, 64, -32, -24, 0, 0);
        //drawCubeOnPaths(paths, 64, -32, 24, 0, 0);
        //drawCubeOnPaths(paths, 64, 32, -24, 0, 0);
        //drawCubeOnPaths(paths, 32, 16, 12, 0, 0);
        //drawCubeOnPaths(paths, 16, 8, 6, 0, 0);
        //drawCubeOnPaths(paths, 8, 4, 2, 0, 0);
        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();

        Drawing drawing = new Drawing();
        drawing.setCurves(paths);

        setContentView(new SurfaceRenderer(this, drawing, surfaceAttributes));
    }

    private void drawCubeOnPaths(ArrayList<Curve> paths, int len, int wid, int dep, int start_x, int start_y) {

        Point p1 = new Point(start_x, start_y);
        Point p2 = new Point(wid, start_y);
        Point p3 = new Point(wid, len);
        Point p4 = new Point(start_x, len);

        Point p5 = new Point(p1.x - dep, p1.y - dep);
        Point p6 = new Point(p2.x - dep, p2.y - dep);
        Point p7 = new Point(p3.x - dep, p3.y - dep);
        Point p8 = new Point(p4.x - dep, p4.y - dep);


        paths.add(getBlueLine(p1, p2));
        paths.add(getBlueLine(p2, p3));
        paths.add(getBlueLine(p3, p4));
        paths.add(getBlueLine(p4, p1));

        paths.add(getBlueLine(p5, p6));
        paths.add(getBlueLine(p6, p7));
        paths.add(getBlueLine(p7, p8));
        paths.add(getBlueLine(p8, p5));

        paths.add(getBlueLine(p1, p5));
        paths.add(getBlueLine(p2, p6));
        paths.add(getBlueLine(p3, p7));
        paths.add(getBlueLine(p4, p8));

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