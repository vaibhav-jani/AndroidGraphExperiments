package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.MathCurveView;
import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.drawings.boxes.filled.FilledBox;

import java.util.ArrayList;

public class EightBoxesColored extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l1 = 64 * 4;
        int w1 = 32 * 4;
        int d1 = 24 * 4;

        int l2 = 64 * 2;
        int w2 = 32 * 2;
        int d2 = 24 * 2;

        FilledBox box = new FilledBox(l1, w1, d1, 0, 0);
        FilledBox box2 = new FilledBox(l2, w2, d2, box.getBr().x, box.getBr().y);
        FilledBox box3 = new FilledBox(l2, w2, d2, -100, -100);
        FilledBox box4 = new FilledBox(l2, w2, d2, -100, 100);
        FilledBox box5 = new FilledBox(-l2, -w2, d2, 100, -100);
        FilledBox box6 = new FilledBox(l1, w1, -d1, box2.getBr().x, box2.getBr().y);
        FilledBox box7 = new FilledBox(l1, -w1, d1, box4.getBlr().x, box4.getBlr().y);
        FilledBox box8 = new FilledBox(-l1, -w1, -d1, box3.getBl().x, box3.getBl().y);

        box8.setSideColor("#ffff00");
        box8.setTopColor("#ff00ff");
        box8.setFrontColor("#00ffff");
        box8.setColor("#000000");

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(box);
        drawings.add(box2);
        drawings.add(box3);
        drawings.add(box4);
        drawings.add(box5);
        drawings.add(box6);
        drawings.add(box7);
        drawings.add(box8);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new MathCurveView(this, drawings, surfaceAttributes));
    }
}