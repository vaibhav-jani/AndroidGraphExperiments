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

public class ButterflyCurve extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<Point> points1 = new ArrayList<Point>();
        //ArrayList<SurfacePoint> points2 = new ArrayList<SurfacePoint>();

        for (double i = 0; i <= 200.8; i = i + 0.1f) {

            double sin_i = Math.sin(i);
            double cos_i = Math.cos(i);

            double bc_f = (Math.pow(Math.E, cos_i)) - (2 * Math.cos(4 * i) - Math.pow(Math.sin(i / 12), 5));

            double x = sin_i * bc_f;
            double y = cos_i * bc_f;

            points1.add(new Point((float) x, (float) y));

            //points2.add(new SurfacePoint(-y, x));
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setStrokeWidthOfPath(0.99999f);
        //defAttribs.setPathColor("#ff0000");
        defAttribs.setDrawPoints(true);

        Drawing drawing = new Drawing();
        drawing.addCurve(new Curve(points1, defAttribs));
        //drawing.addCurve(new Curve(points2, defAttribs));

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(drawing);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}