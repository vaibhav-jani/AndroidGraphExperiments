package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.Drawer;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

import java.util.ArrayList;

public class SpiralTest7 extends Activity {
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


        float x0 = 0;
        float y0 = 0;
        float radius = 20;

        for (float i = 0; i <= 202; i = i + 0.1f) {
            points.add(new SurfacePoint(x0 + (radius * ((float) Math.cos(i))), y0 + (radius * ((float) Math.sin(i)))));
            if (i < 40) {
                //radius = radius+0.025f;
                //x0 = x0-0.15f;
                y0 = y0 + 0.050f;
            } else if (i < 104) {
                radius = radius + 0.025f;
                //x0 = x0-0.15f;
                y0 = y0 + 0.050f;
            } else if (i < 158) {
                //radius = radius-0.025f;
                //x0 = x0-0.15f;
                y0 = y0 + 0.050f;
            } else {
                radius = radius + 0.025f;
                //x0 = x0-0.15f;
                y0 = y0 + 0.050f;
            }
        }


        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setDrawPoints(false);

        Drawing drawing = new Drawing();
        drawing.addCurve(new Curve(points, defAttribs));

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(drawing);

        Drawer drawer = new Drawer(drawings, null, this);
        drawer.draw();
    }
}