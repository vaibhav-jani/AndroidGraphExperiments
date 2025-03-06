package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.ExBox;
import com.ai.engg.curves.drawings.boxes.filled.FilledOpenBox;

import java.util.ArrayList;


public class ExComplexIsometric extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        float l = 0.8f;
        float w = 0.4f;
        float d = 0.3f;

        FilledOpenBox box = new FilledOpenBox(l * 24, w * 24, d * 24, 0, 0);

        ExBox box1 = new ExBox(l * 8, w * 8, -d * 8, box.getBlr().x, box.getBlr().y);
        ExBox box2 = new ExBox(l * 10, -w * 8, -d * 10, box.getBrr().x, box.getBrr().y);
        ExBox box3 = new ExBox(l * 4, w * 4, -d * 4, box1.getBl().x, box1.getBl().y);
        ExBox box4 = new ExBox(l * 5, -w * 4, d * 4, box.getBr().x, box.getBr().y);
        ExBox box6 = new ExBox(l * 8, -w * 5, -d * 6, box2.getTrr().x, box2.getTrr().y);
        ExBox box7 = new ExBox(l * 2, w * 7, d * 7, box.getBl().x, box.getBl().y);
        ExBox box8 = new ExBox(l * 6, w * 6, -d * 6, box1.getTlr().x, box1.getTlr().y);
        ExBox box9 = new ExBox(l * 4, -w * 4, d * 4, box8.getTr().x, box8.getTr().y);
        ExBox box10 = new ExBox(l * 3, w * 3, d * 3, box9.getTopCenter().x, box9.getTopCenter().y);
        ExBox box11 = new ExBox(l * 10, w * 5, d * 5, box7.getTl().x, box7.getTl().y);
        ExBox box12 = new ExBox(l * 5, -w * 4, -d * 4, box6.getTopCenter().x, box6.getTopCenter().y);
        ExBox box13 = new ExBox(l * 2, -w * 2, d * 2, box4.getBrr().x, box4.getBrr().y);
        ExBox box14 = new ExBox(l * 4, -w * 2, -d * 2, box6.getBr().x, box6.getBr().y);
        ExBox box15 = new ExBox(l * 6, w * 3, d * 3, box2.getTl().x, box2.getTl().y);
        ExBox box16 = new ExBox(l * 6, -w * 1, -d * 1, box11.getTrr().x, box11.getTrr().y);
        ExBox box17 = new ExBox(l * 4, w * 4, d * 4, box11.getTopCenter().x, box11.getTopCenter().y + box16.getLength());
        ExBox box18 = new ExBox(l * 4, w * 2, d * 2, box10.getTopCenter().x, box10.getTopCenter().y);
        ExBox box19 = new ExBox(l * 3, w * 2, -d * 2, box17.getTlr().x, box17.getTlr().y);
        ExBox box20 = new ExBox(l * 3, -w * 3, -d * 3, box12.getTopCenter().x, box12.getTopCenter().y);
        ExBox box21 = new ExBox(l * 2, w * 2, -d * 2, box3.getTlr().x, box3.getTlr().y);
        ExBox box22 = new ExBox(l * 4, -w * 3, -d * 3, box15.getTopCenter().x, box15.getTopCenter().y);
        ExBox box23 = new ExBox(l * 4, w * 4, -d * 6, box1.getBrr().x, box1.getBrr().y);
        ExBox box24 = new ExBox(l * 3, -w * 2, d * 2, box23.getTopCenter().x, box23.getTopCenter().y);
        ExBox box25 = new ExBox(l * 6, -w * 2, d * 2, box22.getTopCenter().x, box22.getTopCenter().y);
        ExBox box26 = new ExBox(l * 8, -w * 5, d * 5, box4.getBl().x, box4.getBl().y);
        ExBox box5 = new ExBox(l * 3, -w * 3, d * 3, box26.getBl().x, box26.getBl().y);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        // drawings.add(box);
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
        drawings.add(box14);
        drawings.add(box15);
        drawings.add(box16);
        drawings.add(box17);
        drawings.add(box18);
        drawings.add(box19);
        drawings.add(box20);
        drawings.add(box21);
        drawings.add(box22);
        drawings.add(box23);
        drawings.add(box24);
        drawings.add(box25);
        drawings.add(box26);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}