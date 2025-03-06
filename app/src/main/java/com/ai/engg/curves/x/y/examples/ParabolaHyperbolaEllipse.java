package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.conic.sections.Ellipse;
import com.ai.engg.curves.drawings.conic.sections.Hyperbola;
import com.ai.engg.curves.drawings.conic.sections.Parabola;

import java.util.ArrayList;

public class ParabolaHyperbolaEllipse extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();

        drawings.add(new Ellipse(0, 0, 10, 12, Ellipse.X));
        drawings.add(new Ellipse(0, 0, 6, 6, Ellipse.Y));

        drawings.add(new Hyperbola(0, 0, -10, 10, 2, 3, Hyperbola.NEGATIVE_X));
        drawings.add(new Hyperbola(0, 0, -10, 10, 2, 3, Hyperbola.POSITIVE_X));

        drawings.add(new Hyperbola(0, 0, -10, 10, 3, 2, Hyperbola.NEGATIVE_X));
        drawings.add(new Hyperbola(0, 0, -10, 10, 3, 2, Hyperbola.POSITIVE_X));

        drawings.add(new Parabola(0, 0, -10, 10, 10, 10, Hyperbola.NEGATIVE_Y));
        drawings.add(new Parabola(0, 0, -10, 10, 10, 10, Hyperbola.POSITIVE_Y));
		
		/*drawings.add(new Hyperbola(0, 0, -10, 10, 3, 2, Hyperbola.NEGATIVE_Y));
		drawings.add(new Hyperbola(0, 0, -10, 10, 3, 2, Hyperbola.POSITIVE_Y));
		
		drawings.add(new Hyperbola(0, 0, -10, 10, 6, 6, Hyperbola.NEGATIVE_X));
		drawings.add(new Hyperbola(0, 0, -10, 10, 6, 6, Hyperbola.POSITIVE_X));*/
        //drawings.add(new SinCurve(-4, 4));
        //drawings.add(new CosCurve(-4, 4));

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}