package com.ai.engg.curves.x.y.examples;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.Box;
import com.ai.engg.curves.drawings.boxes.OpenBox;

import java.util.ArrayList;

public class SimpleIsoMetricColor extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        float l = 0.32f;
        float w = 0.16f;
        float d = 0.12f;

        OpenBox box = new OpenBox(l * 25, w * 25, d * 25, 0, 0);

        Box box1 = new Box(l * 8, w * 8, -d * 8, box.getBlr().x, box.getBlr().y);
        Box box2 = new Box(l * 10, -w * 8, -d * 8, box.getBrr().x, box.getBrr().y);
        Box box3 = new Box(l * 4, w * 3, -d * 4, box1.getBl().x, box1.getBl().y);
        Box box4 = new Box(l * 5, -w * 4, d * 4, box.getBr().x, box.getBr().y);
        Box box5 = new Box(l * 3, w * 3, d * 3, box.getWidth() / 2, 0);
        Box box6 = new Box(l * 5, -w * 4, -d * 4, box2.getTrr().x, box2.getTrr().y);
        Box box7 = new Box(l * 3, w * 3, d * 3, box1.getTl().x, box1.getTl().y);
        Box box8 = new Box(l * 6, w * 5, d * 6, box1.getTopCenter().x, box1.getTopCenter().y);
        Box box9 = new Box(l * 4, w * 3, d * 3, box8.getTopCenter().x, box8.getTopCenter().y);
        Box box10 = new Box(l * 3, w * 2, d * 2, box9.getTopCenter().x, box9.getTopCenter().y);

        box1.setColor("#ff0000");
        ArrayList<Drawing> drawings = new ArrayList<>();
        drawings.add(box);
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

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}