package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.globe.Globe;

import java.util.ArrayList;

public class Uranus extends Activity {
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
		
		/*drawings.add(new Ellipse(0, -5, 5, 1, Ellipse.X));		
		drawings.add(new Ellipse(0, -4, 6, 2, Ellipse.X));
		drawings.add(new Ellipse(0, -3, 7, 3, Ellipse.X));
		drawings.add(new Ellipse(0, -2, 8, 4, Ellipse.X));
		drawings.add(new Ellipse(0, -1, 9, 5, Ellipse.X));
		drawings.add(new Ellipse(0, 0, 10, 6, Ellipse.X));*/
		/*drawings.add(new Ellipse(0, 1, 9, 5, Ellipse.Y));
		drawings.add(new Ellipse(0, 2, 8, 4, Ellipse.Y));
		drawings.add(new Ellipse(0, 3, 7, 3, Ellipse.Y));
		drawings.add(new Ellipse(0, 4, 6, 2, Ellipse.Y));
		drawings.add(new Ellipse(0, 5, 5, 1, Ellipse.Y));*/

        drawings.add(new Globe(0, 0, 10));
		
		/*drawings.add(new Ellipse(-5, 0, 1, 5, Ellipse.X));		
		drawings.add(new Ellipse(-4, 0, 2, 6, Ellipse.X));
		drawings.add(new Ellipse(-3, 0, 3, 7, Ellipse.X));
		drawings.add(new Ellipse(-2, 0, 4, 8, Ellipse.X));
		drawings.add(new Ellipse(-1, 0, 5, 9, Ellipse.X));
		drawings.add(new Ellipse(0, 0, 6, 10, Ellipse.X));*/
		/*drawings.add(new Ellipse(1, 0, 5, 9, Ellipse.X));
		drawings.add(new Ellipse(2, 0, 4, 8, Ellipse.X));
		drawings.add(new Ellipse(3, 0, 3, 7, Ellipse.X));
		drawings.add(new Ellipse(4, 0, 2, 6, Ellipse.X));
		drawings.add(new Ellipse(5, 0, 1, 5, Ellipse.X));*/

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}