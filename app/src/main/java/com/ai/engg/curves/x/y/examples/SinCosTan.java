package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.MathCurveView;
import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.drawings.trigmometric.CosCurve;
import com.ai.engg.curves.drawings.trigmometric.SinCurve;
import com.ai.engg.curves.drawings.trigmometric.TanCurve;

import java.util.ArrayList;


public class SinCosTan extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<Drawing> drawings = new ArrayList<>();
        SinCurve sinCurve = new SinCurve(-7, 7);
        sinCurve.setColor("#ff0000");

        CosCurve cosCurve = new CosCurve(-7, 7);
        cosCurve.setColor("#00ff00");

        TanCurve tanCurve = new TanCurve(-7, 7);

        drawings.add(sinCurve);
        drawings.add(cosCurve);
        drawings.add(tanCurve);
        // drawings.add(new CotCurve(-10, 10));

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new MathCurveView(this, drawings, surfaceAttributes));
    }
}