package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;

import java.util.ArrayList;


public class TheRing extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

        for (float i = 0; i < 360; i = i + 1f) {
            points.add(new SurfacePoint(5 * ((float) Math.cos(i)), 5 * ((float) Math.sin(i))));
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setDrawPoints(true);

        Drawing drawing = new Drawing();
        drawing.addCurve(new Curve(points, defAttribs));

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(drawing);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}