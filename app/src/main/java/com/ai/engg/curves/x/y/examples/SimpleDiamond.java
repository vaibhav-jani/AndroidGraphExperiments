package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.Drawer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.piramid.Pyramid;

import java.util.ArrayList;

public class SimpleDiamond extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l = 40;
        int w = 20;
        int d = 10;

        Pyramid p111 = new Pyramid(l * 4, w * 4, d * 4, 0, 0, Pyramid.TOP);
        Pyramid p112 = new Pyramid(l * 4, w * 4, d * 4, p111.getBlr().x, p111.getBlr().y, Pyramid.TOP);

        Pyramid p121 = new Pyramid(l * 4, w * 4, d * 4, p111.getBr().x, p111.getBr().y, Pyramid.TOP);
        Pyramid p122 = new Pyramid(l * 4, w * 4, d * 4, p121.getBlr().x, p121.getBlr().y, Pyramid.TOP);

        Pyramid p000 = new Pyramid(l * 4, w * 4, d * 4, p111.getTopCenter().x, p111.getTopCenter().y, Pyramid.TOP);

        l = -l;

        Pyramid p111r = new Pyramid(l * 4, w * 4, d * 4, 0, 0, Pyramid.BOTTOM);
        Pyramid p112r = new Pyramid(l * 4, w * 4, d * 4, p111r.getTlr().x, p111r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p121r = new Pyramid(l * 4, w * 4, d * 4, p111r.getTr().x, p111r.getTr().y, Pyramid.BOTTOM);
        Pyramid p122r = new Pyramid(l * 4, w * 4, d * 4, p121r.getTlr().x, p121r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p000r = new Pyramid(l * 4, w * 4, d * 4, p111r.getBottomCenter().x, p111r.getBottomCenter().y, Pyramid.BOTTOM);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();

        drawings.add(p111);
        drawings.add(p112);

        drawings.add(p121);
        drawings.add(p122);

        drawings.add(p000);

        drawings.add(p111r);
        drawings.add(p112r);

        drawings.add(p121r);
        drawings.add(p122r);

        drawings.add(p000r);

        Drawer drawer = new Drawer(drawings, null, this);
        drawer.draw();
    }
}