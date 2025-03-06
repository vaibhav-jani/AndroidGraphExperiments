package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.filledboxes.ClosedBox;

import java.util.ArrayList;

public class FirstIsoSpace extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l1 = 100;
        int w1 = 100;
        int d1 = 60;

		/*int l2 = 25;
		int w2 = 25;
		int d2 = 15;*/

        ClosedBox baseBox = new ClosedBox(l1 * 0.01f, w1, d1, 0, 0);
        ClosedBox box1 = new ClosedBox(l1 * 0.7f, w1 * 0.10f, -d1 * 0.40f, baseBox.getBlr().x, baseBox.getBlr().y);
        ClosedBox box2 = new ClosedBox(l1 * 0.7f, w1 * 0.40f, -d1 * 0.10f, box1.getBrr().x, box1.getBrr().y);
        ClosedBox box3 = new ClosedBox(l1 * 0.35f, -w1 * 0.20f, d1 * 0.15f, box1.getTr().x, box1.getTr().y);
        ClosedBox box4 = new ClosedBox(l1 * 0.15f, w1 * 0.10f, -d1 * 0.10f, box3.getTlr().x, box3.getTlr().y);
        ClosedBox box5 = new ClosedBox(l1 * 0.25f, w1 * 0.20f, -d1 * 0.20f, box2.getBl().x, box2.getBl().y);
        ClosedBox box6 = new ClosedBox(l1 * 0.50f, w1 * 0.10f, -d1 * 0.10f, box5.getBrr().x, box5.getBrr().y);
        ClosedBox box7 = new ClosedBox(l1 * 0.15f, -w1 * 0.15f, -d1 * 0.20f, box6.getTrr().x, box6.getTrr().y);
        ClosedBox box8 = new ClosedBox(l1 * 0.50f, w1 * 0.10f, d1 * 0.10f, box7.getTl().x, box7.getTl().y);
        ClosedBox box9 = new ClosedBox(l1 * 0.45f, w1 * 0.30f, d1 * 0.30f, baseBox.getTl().x + 15, baseBox.getTl().y);
        ClosedBox box10 = new ClosedBox(l1 * 0.65f, w1 * 0.05f, d1 * 0.05f, box9.getTl().x, box9.getTl().y);
        ClosedBox box11 = new ClosedBox(l1 * 0.01f, -w1 * 0.25f, d1 * 0.25f, box10.getTr().x, box10.getTr().y);
        ClosedBox box12 = new ClosedBox(l1 * 0.65f, w1 * 0.05f, -d1 * 0.05f, box11.getTlr().x, box11.getTlr().y);
        ClosedBox box13 = new ClosedBox(l1 * 0.01f, w1 * 0.25f, d1 * 0.25f, box8.getTl().x, box8.getTl().y);
        //ClosedBox box13 = new ClosedBox(l1*0.65f, w1*0.05f, d1*0.05f, box11.getTlr().x, box11.getTlr().y);

        //ClosedBox box13 = new ClosedBox(l1*0.15f, -w1*0.30f, -d1*0.30f, baseBox.getBrr().x, baseBox.getBrr().y);
        //ClosedBox box14 = new ClosedBox(l1*0.85f, w1*0.10f, -d1*0.10f, box13.getTlr().x, box14.getTlr().y);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();

        drawings.add(baseBox);
        drawings.add(box1);
        drawings.add(box2);
        drawings.add(box3);
        drawings.add(box4);
        drawings.add(box5);
        drawings.add(box6);
        drawings.add(box7);
        drawings.add(box8);
        drawings.add(box9);
        drawings.add(box10);
        drawings.add(box11);
        drawings.add(box12);
        drawings.add(box13);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}