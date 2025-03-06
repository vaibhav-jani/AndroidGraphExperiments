package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.filled.FilledBox;

import java.util.ArrayList;

public class FourBoxesStacked extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        FilledBox box4 = new FilledBox(64 * 4, 32 * 4, 24 * 4, 0, 0);
        FilledBox box3 = new FilledBox(64 * 3, 32 * 3, 24 * 3, (box4.getTopCenter().x - 96), (box4.getTopCenter().y - 36));
        FilledBox box2 = new FilledBox(64 * 2, 32 * 2, 24 * 2, (box3.getTopCenter().x - 64), (box3.getTopCenter().y - 32));
        FilledBox box1 = new FilledBox(64, 32, 24, (box2.getTopCenter().x - 32), (box2.getTopCenter().y - 16));
		
		/*FilledBox box4x = new FilledBox(64*4, -32*4, 24*4, 0, 0);
		FilledBox box3x = new FilledBox(64*3, 32*3, 24*3, (box4x.getTopCenter().x - 96), (box4x.getTopCenter().y - 36));
		FilledBox box2x = new FilledBox(64*2, 32*2, 24*2, (box3x.getTopCenter().x - 64), (box3x.getTopCenter().y - 32));
		FilledBox box1x = new FilledBox(64*1, 32*1, 24*1, (box2x.getTopCenter().x - 32), (box2x.getTopCenter().y - 16));
		
		FilledBox box4y = new FilledBox(64*4, 32*4, -24*4, 0, 0);
		FilledBox box3y = new FilledBox(64*3, 32*3, 24*3, (box4y.getTopCenter().x - 96), (box4y.getTopCenter().y - 36));
		FilledBox box2y = new FilledBox(64*2, 32*2, 24*2, (box3y.getTopCenter().x - 64), (box3y.getTopCenter().y - 32));
		FilledBox box1y = new FilledBox(64*1, 32*1, 24*1, (box2y.getTopCenter().x - 32), (box2y.getTopCenter().y - 16));
		
		FilledBox box4z = new FilledBox(64*4, -32*4, -24*4, 0, 0);
		FilledBox box3z = new FilledBox(64*3, 32*3, 24*3, (box4z.getTopCenter().x - 96), (box4z.getTopCenter().y - 36));
		FilledBox box2z = new FilledBox(64*2, 32*2, 24*2, (box3z.getTopCenter().x - 64), (box3z.getTopCenter().y - 32));
		FilledBox box1z = new FilledBox(64*1, 32*1, 24*1, (box2z.getTopCenter().x - 32), (box2z.getTopCenter().y - 16));*/

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(box1);
        drawings.add(box2);
        drawings.add(box3);
        drawings.add(box4);
		
		/*drawings.add(box1x);
		drawings.add(box2x);
		drawings.add(box3x);
		drawings.add(box4x);
		
		drawings.add(box1y);
		drawings.add(box2y);
		drawings.add(box3y);
		drawings.add(box4y);
		
		drawings.add(box1z);
		drawings.add(box2z);
		drawings.add(box3z);
		drawings.add(box4z);*/

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}