package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.piramid.FilledPyramid;

import java.util.ArrayList;

public class FilledPyramidDiamond3 extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l = 20;
        int w = 10;
        int d = 8;

        FilledPyramid p211 = new FilledPyramid(l * 4, w * 4, d * 4, 0, 0, FilledPyramid.BOTTOM);
        FilledPyramid p212 = new FilledPyramid(-l * 4, w * 4, d * 4, p211.getTlr().x, p211.getTlr().y, FilledPyramid.BOTTOM);
        FilledPyramid p213 = new FilledPyramid(-l * 4, w * 4, d * 4, p212.getTlr().x, p212.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p221 = new FilledPyramid(-l * 4, w * 4, d * 4, p211.getTr().x, p211.getTr().y, FilledPyramid.BOTTOM);
        FilledPyramid p222 = new FilledPyramid(-l * 4, w * 4, d * 4, p221.getTlr().x, p221.getTlr().y, FilledPyramid.BOTTOM);
        FilledPyramid p223 = new FilledPyramid(-l * 4, w * 4, d * 4, p222.getTlr().x, p222.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p231 = new FilledPyramid(-l * 4, w * 4, d * 4, p221.getTr().x, p221.getTr().y, FilledPyramid.BOTTOM);
        FilledPyramid p232 = new FilledPyramid(-l * 4, w * 4, d * 4, p231.getTlr().x, p231.getTlr().y, FilledPyramid.BOTTOM);
        FilledPyramid p233 = new FilledPyramid(-l * 4, w * 4, d * 4, p232.getTlr().x, p232.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p111 = new FilledPyramid(l * 4, w * 4, d * 4, p211.getTopCenter().x, p211.getTopCenter().y, FilledPyramid.BOTTOM);
        FilledPyramid p112 = new FilledPyramid(-l * 4, w * 4, d * 4, p111.getTlr().x, p111.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p121 = new FilledPyramid(-l * 4, w * 4, d * 4, p111.getTr().x, p111.getTr().y, FilledPyramid.BOTTOM);
        FilledPyramid p122 = new FilledPyramid(-l * 4, w * 4, d * 4, p121.getTlr().x, p121.getTlr().y, FilledPyramid.BOTTOM);

        FilledPyramid p000 = new FilledPyramid(l * 4, w * 4, d * 4, p111.getTopCenter().x, p111.getTopCenter().y, FilledPyramid.BOTTOM);

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