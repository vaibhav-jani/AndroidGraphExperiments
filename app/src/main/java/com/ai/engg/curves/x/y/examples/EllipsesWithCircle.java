package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.MathCurveView;
import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.drawings.conic.sections.Ellipse;

import java.util.ArrayList;

public class EllipsesWithCircle extends Activity {

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

        drawings.add(new Ellipse(0, 0, 4, 5, Ellipse.X));
        drawings.add(new Ellipse(0, 0, 4, 5, -1.57f));
        drawings.add(new Ellipse(0, 0, 4, 5, 1.57f));
		/*
			drawings.add(new Ellipse(0, 0, 4, 5, 0.585f));
			drawings.add(new Ellipse(0, 0, 4, 5, -0.585f));
		 */

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new MathCurveView(this, drawings, surfaceAttributes));
    }
}