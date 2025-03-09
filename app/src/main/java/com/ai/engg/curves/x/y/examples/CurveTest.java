package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.display.window.MathCurveView;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class CurveTest extends Activity {
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

        for (float i = -20; i <= 20; i = i + 1f) {

            if (i != 0) {
                float x = i;
                float y = (float) 1 / x;

                Log.d("Curve test", x + " | " + y);
                points.add(new Point(x, y));
            }
        }

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setDrawPoints(true);

        Drawing drawing = new Drawing();
        drawing.addCurve(new Curve(points, defAttribs));

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(drawing);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new MathCurveView(this, drawings, surfaceAttributes));
    }
}