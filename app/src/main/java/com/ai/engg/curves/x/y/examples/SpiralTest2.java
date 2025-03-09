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

public class SpiralTest2 extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<Point> points = new ArrayList<Point>();

        float x0 = 0;
        float y0 = 0;
        float radius = 1;

        for (float i = 0; i <= 108; i = i + 0.1f) {
            points.add(new Point(x0 + (radius * ((float) Math.cos(i))), y0 + (radius * ((float) Math.sin(i)))));
            if (i < 36) {
                radius = radius + 0.075f;
                x0 = x0 + 0.15f;
                y0 = y0 + 0.15f;
            } else if (i < 72) {
                radius = radius - 0.075f;
                //x0 = x0-0.15f;
                y0 = y0 + 0.15f;
            } else {
                radius = radius + 0.075f;
                //x0 = x0-0.15f;
                y0 = y0 + 0.15f;
            }
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setDrawPoints(false);
        defAttribs.setStrokeWidthOfPath(2.25f);

        Drawing drawing = new Drawing();
        drawing.addCurve(new Curve(points, defAttribs));

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(drawing);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new MathCurveView(this, drawings, surfaceAttributes));
    }
}