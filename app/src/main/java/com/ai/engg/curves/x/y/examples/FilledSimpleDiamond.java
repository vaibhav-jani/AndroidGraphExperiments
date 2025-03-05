package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.Drawer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.piramid.FilledPyramid;

import java.util.ArrayList;

public class FilledSimpleDiamond extends Activity {

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

        FilledPyramid p111 = new FilledPyramid(l * 4, w * 4, d * 4, 0, 0, FilledPyramid.TOP);
        FilledPyramid p112 = new FilledPyramid(l * 4, w * 4, d * 4, p111.getBlr().x, p111.getBlr().y, FilledPyramid.TOP);

        FilledPyramid p121 = new FilledPyramid(l * 4, w * 4, d * 4, p111.getBr().x, p111.getBr().y, FilledPyramid.TOP);
        FilledPyramid p122 = new FilledPyramid(l * 4, w * 4, d * 4, p121.getBlr().x, p121.getBlr().y, FilledPyramid.TOP);

        FilledPyramid p000 = new FilledPyramid(l * 4, w * 4, d * 4, p111.getTopCenter().x, p111.getTopCenter().y, FilledPyramid.TOP);

        l = -l;

        FilledPyramid p111r = new FilledPyramid(l * 4, w * 4, d * 4, 0, 0, FilledPyramid.BOTTOM);
        FilledPyramid p112r = new FilledPyramid(l * 4, w * 4, d * 4, p111r.getTlr().x, p111r.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p121r = new FilledPyramid(l * 4, w * 4, d * 4, p111r.getTr().x, p111r.getTr().y, FilledPyramid.BOTTOM);
        FilledPyramid p122r = new FilledPyramid(l * 4, w * 4, d * 4, p121r.getTlr().x, p121r.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p000r = new FilledPyramid(l * 4, w * 4, d * 4, p111r.getBottomCenter().x, p111r.getBottomCenter().y, FilledPyramid.BOTTOM);

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