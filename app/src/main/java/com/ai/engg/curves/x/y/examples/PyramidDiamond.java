package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.piramid.Pyramid;

import java.util.ArrayList;

public class PyramidDiamond extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l = 4;
        int w = 2;
        int d = 1;

        Pyramid p211 = new Pyramid(l * 4, w * 4, d * 4, 0, 0, Pyramid.TOP);
        Pyramid p212 = new Pyramid(l * 4, w * 4, d * 4, p211.getBlr().x, p211.getBlr().y, Pyramid.TOP);
        Pyramid p213 = new Pyramid(l * 4, w * 4, d * 4, p212.getBlr().x, p212.getBlr().y, Pyramid.TOP);

        Pyramid p221 = new Pyramid(l * 4, w * 4, d * 4, p211.getBr().x, p211.getBr().y, Pyramid.TOP);
        Pyramid p222 = new Pyramid(l * 4, w * 4, d * 4, p221.getBlr().x, p221.getBlr().y, Pyramid.TOP);
        Pyramid p223 = new Pyramid(l * 4, w * 4, d * 4, p222.getBlr().x, p222.getBlr().y, Pyramid.TOP);

        Pyramid p231 = new Pyramid(l * 4, w * 4, d * 4, p221.getBr().x, p221.getBr().y, Pyramid.TOP);
        Pyramid p232 = new Pyramid(l * 4, w * 4, d * 4, p231.getBlr().x, p231.getBlr().y, Pyramid.TOP);
        Pyramid p233 = new Pyramid(l * 4, w * 4, d * 4, p232.getBlr().x, p232.getBlr().y, Pyramid.TOP);

        Pyramid p111 = new Pyramid(l * 4, w * 4, d * 4, p211.getTopCenter().x, p211.getTopCenter().y, Pyramid.TOP);
        Pyramid p112 = new Pyramid(l * 4, w * 4, d * 4, p111.getBlr().x, p111.getBlr().y, Pyramid.TOP);

        Pyramid p121 = new Pyramid(l * 4, w * 4, d * 4, p111.getBr().x, p111.getBr().y, Pyramid.TOP);
        Pyramid p122 = new Pyramid(l * 4, w * 4, d * 4, p121.getBlr().x, p121.getBlr().y, Pyramid.TOP);

        Pyramid p000 = new Pyramid(l * 4, w * 4, d * 4, p111.getTopCenter().x, p111.getTopCenter().y, Pyramid.TOP);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();

        drawings.add(p211);
        drawings.add(p212);
        drawings.add(p213);

        drawings.add(p221);
        drawings.add(p222);
        drawings.add(p223);

        drawings.add(p231);
        drawings.add(p232);
        drawings.add(p233);

        drawings.add(p111);
        drawings.add(p112);

        drawings.add(p121);
        drawings.add(p122);

        drawings.add(p000);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
        setContentView(new SurfaceRenderer(this, drawings, surfaceAttributes));
    }
}